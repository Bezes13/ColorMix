package com.games.colormix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattowatch.manager.SharedPreferencesManager
import kotlinx.coroutines.CoroutineDispatcher
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
        placeRandomColorField()
        listenToEvent()
        _viewState.update { it.copy(isLoading = false) }
    }

    private fun placeRandomColorField() {
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
                        colorFieldNextId ++
                        ColorField(colorFieldNextId)
                    } else {
                        colorField
                    }
                }
            }

            _viewState.update { it.copy(gameField = newGameField) }
        } else {
            // GAME OVER
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
                is MainViewEvent.Swipe -> updateGameField(event.direction)
            }
        }
    }

    private fun updateGameField(direction: Direction) {
        val columns = mutableListOf<List<ColorField?>>()
        when (direction) {
            Direction.RIGHT -> {
                for (i in 0..3){
                    columns.add(orderLine(_viewState.value.gameField[i].toMutableList()))
                }
            }
            Direction.LEFT -> {
                for (i in 0..3){
                    columns.add(orderLineReverse(_viewState.value.gameField[i].toMutableList()))
                }
            }
            Direction.DOWN ->{
                val rows = mutableListOf<List<ColorField?>>()
                for (j in 0.. 3) {
                    val mutList = mutableListOf<ColorField?>()
                    for (i in 0..3) {
                        mutList.add(_viewState.value.gameField[i][j])
                    }
                    rows.add(orderLine(mutList))
                }
                // Rotate
                for (j in 0..3) {
                    val row = mutableListOf<ColorField?>()
                    for (i in 0..3) {
                        row.add(rows[i][j])
                    }
                    columns.add(row)
                }
            }
            Direction.UP ->{
                val rows = mutableListOf<List<ColorField?>>()
                for (j in 0.. 3) {
                    val mutList = mutableListOf<ColorField?>()
                    for (i in 0..3) {
                        mutList.add(_viewState.value.gameField[i][j])
                    }
                    rows.add(orderLineReverse(mutList))
                }
                // Rotate
                for (j in 0..3) {
                    val row = mutableListOf<ColorField?>()
                    for (i in 0..3) {
                        row.add(rows[i][j])
                    }
                    columns.add(row)
                }
            }
            Direction.NONE -> {}
        }
        _viewState.update { it.copy(gameField = columns) }
        placeRandomColorField()
    }

    private fun orderLine(list:MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [null, null, B, G]
       var anyMove = true
        while(anyMove){
            anyMove = false
            for (i in 0..2){
                if(list[i] != null && list[i+1] == null){
                    anyMove = true
                    list[i+1] = list[i]
                    list[i] = null
                }
                if(list[i].mergeAllowed(list[i+1])){
                    list[i+1] = list[i+1]!!.merge(list[i]!!)
                    list[i] = null
                }
            }
        }
        return list
    }

    private fun orderLineReverse(list:MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [B, G, null, null]
        var anyMove = true
        while(anyMove){
            anyMove = false
            for (i in 3 downTo 1){
                if(list[i] != null && list[i-1] == null){
                    anyMove = true
                    list[i-1] = list[i]
                    list[i] = null
                }
                if(list[i].mergeAllowed(list[i-1])){
                    list[i-1] = list[i-1]!!.merge(list[i]!!)
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
    data class Swipe(val direction: Direction) : MainViewEvent()
}