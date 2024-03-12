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
            _viewState.update { it.copy(gameField = it.gameField.map { column -> column.map { item -> item?.copy(spawned = false) }  }) }
        }
    }

    private fun fillGameField() {
        val columns = mutableListOf<List<ColorField>>()
        _viewState.value.gameField.forEach {
            val row = mutableListOf<ColorField>()
            it.forEach { _ ->
                row.add(ColorField(colorFieldNextId))
            }
            columns.add(row)
        }
        _viewState.update { it.copy(gameField = columns) }
    }

    private fun placeRandomColorField() : Boolean {
        val emptyFields = mutableListOf<Pair<Int, Int>>()
        _viewState.value.gameField.forEachIndexed { i, column ->
            column.forEachIndexed { j, row ->
                if (row == null) {
                    emptyFields.add(Pair(i, j))
                }
            }
        }
        // Check if there are empty fields available
        if (emptyFields.isNotEmpty()) {
            val (i, j) = emptyFields.random()

            // Create a new ColorField and update the view state
            val newGameField = _viewState.value.gameField.mapIndexed { rowIndex, column ->
                column.mapIndexed { columnIndex, colorField ->
                    if (rowIndex == i && columnIndex == j) {
                        colorFieldNextId++
                        ColorField(colorFieldNextId)
                    } else {
                        colorField
                    }
                }
            }

            _viewState.update { it.copy(gameField = newGameField) }
            return true
        } else {
            // GAME OVER
            return false
        }
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
                is MainViewEvent.Swap -> swapElements(event.from, event.to)
                //is MainViewEvent.Swipe -> updateGameField(event.direction)
                is MainViewEvent.FieldClicked -> fieldClicked(event.pos)
            }
        }
    }

    private fun isDestroyable(
        pos: Pair<Int, Int>,
        fieldsToDestroy: MutableList<Pair<Int, Int>>
    ): Boolean {
        val field = _viewState.value.gameField[pos.first][pos.second]

        hasSameColor(Pair(pos.first + 1, pos.second), field)?.let { if(!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(Pair(pos.first - 1, pos.second), field)?.let { if(!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it)}
        hasSameColor(Pair(pos.first, pos.second + 1), field)?.let { if(!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        hasSameColor(Pair(pos.first, pos.second - 1), field)?.let { if(!fieldsToDestroy.contains(it)) fieldsToDestroy.add(it) }
        return fieldsToDestroy.size > 1
    }

    private fun hasSameColor(pair: Pair<Int, Int>, field: ColorField?): Pair<Int, Int>? {
        val gameBoard = _viewState.value.gameField

        if (field != null && pair.first >= 0 &&
            pair.second >= 0 &&
            pair.first < gameBoard.size &&
            pair.second < gameBoard.size &&
            gameBoard[pair.first][pair.second] != null &&
            gameBoard[pair.first][pair.second]?.color == field.color
        ) {
            return pair
        } else {
            return null
        }
    }

    private fun fieldClicked(pos: Pair<Int, Int>) {
        _viewState.update {
            it.copy(gameField = it.gameField.mapIndexed { column, colorFields ->
                colorFields.mapIndexed { row, colorField ->
                    colorField?.copy(animateFrom = row)
                }
            })
        }
        val fieldsToDestroy = mutableListOf<Pair<Int, Int>>()
        fieldsToDestroy.add(pos)
        if (isDestroyable(pos, fieldsToDestroy)) {
            var lastSize = 0
            while (lastSize != fieldsToDestroy.size){
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
            updateGameField(Direction.RIGHT)
            while (placeRandomColorField()){

            }
            viewModelScope.launch {
                delay(100)
                _viewState.update { it.copy(gameField = it.gameField.map { column -> column.map { item -> item?.copy(spawned = false)  }  }) }
            }
        }
    }

    private fun swapElements(from: Pair<Int, Int>, to: Pair<Int, Int>) {
        val board = _viewState.value.gameField
        if (from.first < 0 || from.second > board.size - 1 || to.first < 0 || to.second > board.size - 1 ||
            from.second < 0 || from.first > board.size - 1 || to.second < 0 || to.first > board.size - 1
        ) {
            return
        }
        if (!board[from.first][from.second].mergeAllowed(board[to.first][to.second])) {
            // DO not swap
            return
        }
        _viewState.update {
            it.copy(gameField = it.gameField.mapIndexed { column, colorFields ->
                List(colorFields.size) { row ->
                    if (column == from.first && row == from.second) {
                        null
                    } else {
                        if (column == to.first && row == to.second) {
                            it.gameField[to.first][to.second].merge(it.gameField[from.first][from.second])
                        } else {
                            it.gameField[column][row]
                        }
                    }
                }
            })
        }
        updateGameField(Direction.RIGHT)
        placeRandomColorField()
    }

    private fun updateGameField(direction: Direction) {
        val columns = mutableListOf<List<ColorField?>>()
        when (direction) {
            Direction.RIGHT -> {
                for (i in 0..<_viewState.value.gameField.size) {
                    columns.add(orderLine(_viewState.value.gameField[i].toMutableList()))
                }
            }

            Direction.LEFT -> {
                for (i in 0..<_viewState.value.gameField.size) {
                    columns.add(orderLineReverse(_viewState.value.gameField[i].toMutableList()))
                }
            }

            Direction.DOWN -> {
                val rows = mutableListOf<List<ColorField?>>()
                for (j in 0..<_viewState.value.gameField.size) {
                    val mutList = mutableListOf<ColorField?>()
                    for (i in 0..<_viewState.value.gameField[j].size) {
                        mutList.add(_viewState.value.gameField[j][i])
                    }
                    rows.add(orderLine(mutList))
                }
                // Rotate
                for (j in 0..<_viewState.value.gameField.size) {
                    val row = mutableListOf<ColorField?>()
                    for (i in 0..<_viewState.value.gameField[j].size) {
                        row.add(rows[j][i])
                    }
                    columns.add(row)
                }
            }

            Direction.UP -> {
                val rows = mutableListOf<List<ColorField?>>()
                for (j in 0..<_viewState.value.gameField.size) {
                    val mutList = mutableListOf<ColorField?>()
                    for (i in 0..<_viewState.value.gameField[j].size) {
                        mutList.add(_viewState.value.gameField[j][i])
                    }
                    rows.add(orderLineReverse(mutList))
                }
                // Rotate
                for (j in 0..<_viewState.value.gameField.size) {
                    val row = mutableListOf<ColorField?>()
                    for (i in 0..<_viewState.value.gameField[j].size) {
                        row.add(rows[j][i])
                    }
                    columns.add(row)
                }
            }

            Direction.NONE -> {}
        }
        _viewState.update { it.copy(gameField = columns) }
        placeRandomColorField()
    }

    private fun orderLine(list: MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [null, null, B, G]
        var anyMove = true
        while (anyMove) {
            anyMove = false
            for (i in 0.._viewState.value.gameField.size-2) {
                if (list[i] != null && list[i + 1] == null) {
                    anyMove = true
                    list[i + 1] = list[i]?.copy(spawned = true)
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

    private fun orderLineReverse(list: MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [B, G, null, null]
        var anyMove = true
        while (anyMove) {
            anyMove = false
            for (i in 3 downTo 1) {
                if (list[i] != null && list[i - 1] == null) {
                    anyMove = true
                    list[i - 1] = list[i]
                    list[i] = null
                }
                if (list[i].mergeAllowed(list[i - 1])) {
                    list[i - 1] = list[i - 1]!!.merge(list[i]!!)
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
}