package com.games.colormix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattowatch.manager.SharedPreferencesManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private var sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()
    private var colorFieldNextId = 0

    init {
        _viewState.update { it.copy(isLoading = true) }
        fillGameField()
        listenToEvent()
        _viewState.update { it.copy(isLoading = false) }
        viewModelScope.launch {
            delay(100)
            _viewState.update {
                it.copy(gameField = it.gameField.map { column ->
                    column.map { item ->
                        item?.copy(
                            spawned = false
                        )
                    }
                })
            }
        }
    }

    private fun fillGameField() {
        val columns = mutableListOf<List<ColorField>>()
        _viewState.value.gameField.forEach {
            val row = mutableListOf<ColorField>()
            it.forEachIndexed { index, _ ->
                row.add(ColorField(colorFieldNextId++, animateTo = index ))
            }
            columns.add(row)
        }
        _viewState.update { it.copy(gameField = columns) }
    }

    fun sendEvent(event: MainViewEvent) {
        viewModelScope.launch(ioDispatcher) {
            _event.emit(event)
        }
    }

    private fun listenToEvent() = viewModelScope.launch(ioDispatcher) {
        _event.collect { event ->
            when (event) {
                is MainViewEvent.SetDialog -> updateDialog(event.dialog)
                is MainViewEvent.Swap -> {}
                //is MainViewEvent.Swipe -> updateGameField(event.direction)
                is MainViewEvent.FieldClicked -> fieldClicked(event.pos)
                is MainViewEvent.SetBlocksAfterAnimation -> updateBlocksAfterAnimation()
                is MainViewEvent.ResetSpawns -> updateDropppedBlocksAfterAnimation()
            }
        }
    }

    private fun updateDropppedBlocksAfterAnimation() {
        _viewState.update { it.copy(gameField = it.gameField.map { colorFields -> colorFields.map { field -> field?.copy(spawned = false) } }) }
    }

    private fun updateBlocksAfterAnimation() {
        _viewState.update { it.copy(gameField = it.gameField.map { colorFields -> colorFields.sortedBy { it?.animateTo } }) }
        // Drop new Blocks
        _viewState.update { it.copy(gameField = it.gameField.map { columns -> columns.mapIndexed { idx, item -> item
            ?: ColorField(colorFieldNextId++, animateTo = idx) } }) }
        viewModelScope.launch {
            delay(100)
            updateDropppedBlocksAfterAnimation()
        }
    }

    private fun isDestroyable(
        pos: Pair<Int, Int>,
        fieldsToDestroy: MutableList<Pair<Int, Int>>
    ): Boolean {
        val field = _viewState.value.gameField[pos.first][pos.second]

        hasSameColor(Pair(pos.first + 1, pos.second), field
        )?.let{ if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(Pair(pos.first - 1, pos.second), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(Pair(pos.first, pos.second + 1), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(Pair(pos.first, pos.second - 1), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        return fieldsToDestroy.size > 1
    }

    private fun hasSameColor(pair: Pair<Int, Int>, field: ColorField?): Pair<Int, Int>? {
        val gameBoard = _viewState.value.gameField

        if (field != null &&
            pair.first >= 0 &&
            pair.second >= 0 &&
            pair.first < gameBoard.size &&
            pair.second < gameBoard[pair.first].size &&
            gameBoard[pair.first][pair.second] != null &&
            gameBoard[pair.first][pair.second]?.color == field.color
        ) {
            return pair
        } else {
            return null
        }
    }

    // Remove Tiles
    // Drop Tiles
    // Add new Tiles
    private fun fieldClicked(pos: Pair<Int, Int>) {
        val fieldsToDestroy = mutableListOf<Pair<Int, Int>>()
        fieldsToDestroy.add(pos)
        if (isDestroyable(pos, fieldsToDestroy)) {
            var lastSize = 0
            while (lastSize != fieldsToDestroy.size) {
                lastSize = fieldsToDestroy.size

                fieldsToDestroy.toMutableList().forEach { position ->
                    isDestroyable(position, fieldsToDestroy)
                }
            }

            _viewState.update {
                it.copy(gameField = it.gameField.mapIndexed { column, colorFields ->
                    colorFields.mapIndexed { row, colorField ->
                        if (fieldsToDestroy.contains(Pair(column, row))) null else colorField
                    }
                })
            }

            val columns = mutableListOf<List<ColorField?>>()
            for (i in 0..<_viewState.value.gameField.size) {
                columns.add(orderLine(_viewState.value.gameField[i].toMutableList()))
            }

            _viewState.update { it.copy(gameField = it.gameField.mapIndexed{ index, colorFields ->
                colorFields.map { colorField -> colorField?.copy( animateTo = columns[index].indexOfFirst{it?.id == colorField.id} ) }
            }) }

        }
    }

    private fun orderLine(list: MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [null, null, B, G]
        var anyMove = true
        while (anyMove) {
            anyMove = false
            for (i in 0.._viewState.value.gameField.size - 1) {
                if (list[i] != null && list[i + 1] == null) {
                    anyMove = true
                    list[i + 1] = list[i]?.copy(spawned = true, animateTo = i+1)
                    list[i] = null
                }
                if (false && list[i].mergeAllowed(list[i + 1])) {
                    list[i + 1] = list[i + 1]!!.merge(list[i]!!)
                    list[i] = null
                }
            }
        }
        return list
    }

    private fun updateDialog(dialog: MainViewDialog) {
        _viewState.update { it.copy(dialog = dialog) }
    }
}

sealed class MainViewEvent {
    data class SetDialog(val dialog: MainViewDialog) : MainViewEvent()

    //data class Swipe(val direction: Direction) : MainViewEvent()
    data class Swap(val from: Pair<Int, Int>, val to: Pair<Int, Int>) : MainViewEvent()
    data class FieldClicked(val pos: Pair<Int, Int>) : MainViewEvent()
    data object SetBlocksAfterAnimation : MainViewEvent()
    data object ResetSpawns : MainViewEvent()
}