package com.games.colormix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    //private var sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()
    private var colorFieldNextId = 0

    init {
        listenToEvent()
        fillGameField()
        letTheBlocksFall()
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
                is MainViewEvent.FieldClicked -> blockClicked(event.pos)
                is MainViewEvent.SetBlocksAfterAnimation -> updateBlocksAfterAnimation()
            }
        }
    }

    private fun fillGameField() {
        _viewState.update { state ->
            val columns = mutableListOf<List<ColorField>>()
            state.gameField.forEach {
                val row = mutableListOf<ColorField>()
                it.forEachIndexed { index, _ ->
                    row.add(ColorField(colorFieldNextId++, animateTo = index))
                }
                columns.add(row)
            }
            val res = placeSpecialBlockAtPosition(
                columns,
                listOf(
                    SpecialBlockPlacement(SpecialType.Rock, Pair(2, 2))
                )
            )
            state.copy(gameField = res)
        }
    }

    private fun placeSpecialBlockAtPosition(
        columns: List<List<ColorField>>,
        specialBlocks: List<SpecialBlockPlacement>
    ): List<List<ColorField>> {
        return columns.mapIndexed { index, row ->
            row.mapIndexed { inner, item ->
                if (specialBlocks.any { it.pos == Pair(index, inner) }) item.copy(
                    specialType = specialBlocks.first { it.pos == Pair(index, inner) }.specialType,
                    color = null
                ) else item
            }
        }
    }

    // Is called when a Block is clicked
    private fun blockClicked(pos: Pair<Int, Int>) {
        val blocksToDestroy = mutableListOf<Pair<Int, Int>>()
        if(!getBlocksToDestroy(blocksToDestroy, pos) ){
            return
        }

        _viewState.update { state ->
            val gameBoard = removeBlocksFromGameBoard(state.gameField, blocksToDestroy)

            val columns = mutableListOf<List<ColorField?>>()
            for (i in gameBoard.indices) {
                columns.add(pushBlocksDown(gameBoard[i].toMutableList()))
            }

            placeNewBlocks(columns)
            state.copy(gameField = gameBoard.mapIndexed { index, colorFields ->
                colorFields.map { colorField -> colorField?.copy(animateTo = columns[index].indexOfFirst { it?.id == colorField.id }) }
            })
        }
    }

    // Place the animated Fields in the correct Spot
    // Add new ColorFields in empty fields
    private fun updateBlocksAfterAnimation() {
        _viewState.update {
            it.copy(gameField = it.gameField.map { colorFields ->
                var fromTop = true
                colorFields.putOnRightPositionAfterAnimation().mapIndexed { idx, item ->
                    if (item == null && fromTop) {
                        ColorField(colorFieldNextId++, animateTo = idx)
                    } else {
                        fromTop = false
                        item
                    }
                }
            })
        }
        letTheBlocksFall()
    }

    private fun letTheBlocksFall() {
        viewModelScope.launch {
            delay(10)
            _viewState.update {
                it.copy(gameField = it.gameField.map { colorFields ->
                    colorFields.map { field ->
                        field?.copy(
                            dropped = false
                        )
                    }
                })
            }
        }
    }

    private fun placeNewBlocks(columns: MutableList<List<ColorField?>>) {
        if (columns.any { colorFields ->
                colorFields.filterIndexed { index, colorField -> index != colorField?.animateTo }
                    .isEmpty()
            }) {
            viewModelScope.launch {
                delay(10)
                updateBlocksAfterAnimation()
            }
        }
    }

    private fun removeBlocksFromGameBoard(
        gameBoard: List<List<ColorField?>>,
        blocksToDestroy: MutableList<Pair<Int, Int>>
    ) = gameBoard.mapIndexed { column, colorFields ->
        colorFields.mapIndexed { row, colorField ->
            if (colorField == null) null else
                if (blocksToDestroy.contains(Pair(column, row))
                ) if (colorField.specialType == SpecialType.Box) colorField.copy(
                    specialType = SpecialType.OpenBox
                ) else null else colorField
        }
    }

    private fun getBlocksToDestroy(blocksToDestroy: MutableList<Pair<Int,Int>>,pos: Pair<Int, Int>) : Boolean{
        blocksToDestroy.add(pos)
        if (!isDestroyable(pos, blocksToDestroy)) {
            return false
        }
        var lastSize = 0
        while (lastSize != blocksToDestroy.size) {
            lastSize = blocksToDestroy.size

            blocksToDestroy.toMutableList().forEach { position ->
                isDestroyable(position, blocksToDestroy)
            }
        }
        return true
    }

    private fun pushBlocksDown(list: MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [null, null, B, G]
        var anyMove = true
        while (anyMove) {
            anyMove = false
            for (i in 0..<_viewState.value.gameField.size) {
                if (list[i] != null && list[i]?.specialType != SpecialType.Rock && list[i + 1] == null) {
                    anyMove = true
                    list[i + 1] = list[i]?.copy(spawned = true, animateTo = i + 1)
                    list[i] = null
                }
            }
        }
        return list
    }

    private fun updateDialog(dialog: MainViewDialog) {
        _viewState.update { it.copy(dialog = dialog) }
    }

    private fun isDestroyable(
        pos: Pair<Int, Int>,
        fieldsToDestroy: MutableList<Pair<Int, Int>>
    ): Boolean {
        val board = _viewState.value.gameField
        val field = board[pos.first][pos.second]
        hasSameColor(
            Pair(pos.first + 1, pos.second), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(
            Pair(pos.first - 1, pos.second), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(
            Pair(pos.first, pos.second + 1), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(
            Pair(pos.first, pos.second - 1), field
        )?.let { if (!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        return fieldsToDestroy.filter { board[it.first][it.second]?.specialType == SpecialType.None }.size > 1
    }

    private fun hasSameColor(pair: Pair<Int, Int>, field: ColorField?): Pair<Int, Int>? {
        val gameBoard = _viewState.value.gameField

        return if (field != null &&
            pair.first >= 0 &&
            pair.second >= 0 &&
            pair.first < gameBoard.size &&
            pair.second < gameBoard[pair.first].size &&
            gameBoard[pair.first][pair.second] != null &&
            (gameBoard[pair.first][pair.second]?.color == field.color ||
                    gameBoard[pair.first][pair.second]?.specialType == SpecialType.Box ||
                    gameBoard[pair.first][pair.second]?.specialType == SpecialType.OpenBox)
        )
            pair else null
    }
}

sealed class MainViewEvent {
    data class SetDialog(val dialog: MainViewDialog) : MainViewEvent()
    data class FieldClicked(val pos: Pair<Int, Int>) : MainViewEvent()
    data object SetBlocksAfterAnimation : MainViewEvent()
}