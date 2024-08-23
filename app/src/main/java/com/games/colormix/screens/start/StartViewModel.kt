package com.games.colormix.screens.start

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.constants.BackgroundBlocks
import com.games.colormix.constants.CurrentLevelString
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType
import com.games.colormix.data.estimateMoves
import com.games.colormix.data.generateObjectDefinition
import com.games.colormix.data.pushBlocksDown
import com.games.colormix.data.startColor
import com.games.colormix.game.LevelLists
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class StartViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val ioDispatcher: CoroutineDispatcher,
    ) : ViewModel() {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    private val _event = MutableSharedFlow<StartViewEvent>()
    private val _viewState = MutableStateFlow(StartViewState())
    val viewState = _viewState.asStateFlow()
    var backgroundSize = IntSize(BackgroundBlocks,BackgroundBlocks*2)
    private var colorFieldNextId = 0

    init {
        listenToEvent()
        removeBlock()
        _viewState.update { state ->
            val columns = mutableListOf<List<ColorField>>()
            for(i in 1..backgroundSize.width) {
                val row = mutableListOf<ColorField>()
                for(j in 1..backgroundSize.height) {
                    row.add(ColorField(colorFieldNextId++))
                }
                columns.add(row)
            }

            state.copy(
                gameField = columns,
            )
        }
    }

    private fun listenToEvent() = viewModelScope.launch(ioDispatcher) {
        _event.collect { event ->
            when (event) {
                is StartViewEvent.RemoveAnimationAt -> {
                    removeBlock()
                }
            }
        }
    }

    private fun removeBlock() {
        viewModelScope.launch(ioDispatcher) {
            while (true){
                delay(500)
                _viewState.update { state ->
                    val pos = randomPair()
                    val blocksToDestroy = mutableListOf<Pair<Int, Int>>()
                    getBlocksToDestroy(blocksToDestroy, pos, state.gameField)

                    val gameBoard = removeBlocksFromGameBoard(state.gameField, blocksToDestroy)

                    val columns = mutableListOf<List<ColorField?>>()
                    for (i in gameBoard.indices) {
                        columns.add(pushBlocksDown(gameBoard[i].toMutableList()))
                    }
                    val newField: List<List<ColorField>> = columns.map {
                        it.map { block ->
                            block ?: ColorField(colorFieldNextId++)
                        }
                    }
                    state.copy(
                        gameField = newField,
                    )

                }
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

    private fun isDestroyable(
        pos: Pair<Int, Int>,
        fieldsToDestroy: MutableList<Pair<Int, Int>>,
        board: List<List<ColorField?>>
    ): Boolean {
        val field = board[pos.first][pos.second]
        if (field?.specialType != SpecialType.None) {
            return false
        }
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
        return fieldsToDestroy.size > 1
    }

    private fun hasSameColor(pair: Pair<Int, Int>, field: ColorField?): Pair<Int, Int>? {
        val gameBoard = _viewState.value.gameField

        return if (field != null &&
            pair.first >= 0 &&
            pair.second >= 0 &&
            pair.first < gameBoard.size &&
            pair.second < gameBoard[pair.first].size && (gameBoard[pair.first][pair.second].color == field.color)
        )
            pair else null
    }

    private fun getBlocksToDestroy(
        blocksToDestroy: MutableList<Pair<Int, Int>>,
        pos: Pair<Int, Int>,
        board: List<List<ColorField?>>
    ): Boolean {
        blocksToDestroy.add(pos)
        if (!isDestroyable(pos, blocksToDestroy, board)) {
            return false
        }
        var lastSize = 0
        while (lastSize != blocksToDestroy.size) {
            lastSize = blocksToDestroy.size

            blocksToDestroy.toMutableList().forEach { position ->
                isDestroyable(position, blocksToDestroy, board)
            }
        }
        return true
    }

    private fun randomPair() =
        Pair(Random.nextInt(0, backgroundSize.width), Random.nextInt(0, backgroundSize.height))

    private fun generateNewLevel(): LevelInfo {
        val questCount = if (Math.random() > 0.5) 1 else 2
        var quests = mutableListOf<LevelQuest>()
        val specials = mutableListOf<SpecialBlockPlacement>()
        for (i in 1..questCount) {
            var typeRandom = Math.random()
            var quest =
                if (typeRandom < 0.33) createColorQuest() else if (typeRandom < 0.66) createMultiQuest() else createBoxQuest()
            while (quests.any { it.specialType == quest.specialType && it.color == quest.color }) {

                typeRandom = Math.random()
                quest =
                    if (typeRandom < 0.33) createColorQuest() else if (typeRandom < 0.66) createMultiQuest() else createBoxQuest()
            }
            quests.add(quest)
        }
        quests.forEach { quest ->
            if (quest.specialType == SpecialType.Box || quest.specialType == SpecialType.OpenBox) {
                for (i in 1..quest.amount) {
                    var pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
                    while (specials.any { it.pos == pos }) {

                        pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
                    }
                    specials.add(SpecialBlockPlacement(quest.specialType, pos))
                }
            }
        }
        for (i in 0..Random.nextInt(0, 5)) {
            var pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
            while (specials.any { it.pos == pos }) {

                pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
            }
            specials.add(SpecialBlockPlacement(SpecialType.Rock, pos))
        }
        quests =
            quests.map { if (it.specialType == SpecialType.Box) it.copy(specialType = SpecialType.OpenBox) else it }
                .toMutableList()
        if (quests.size == 2 && quests[0].specialType == SpecialType.OpenBox && quests[1].specialType == SpecialType.OpenBox) {
            quests = listOf(
                LevelQuest(
                    SpecialType.OpenBox,
                    Color.Transparent,
                    quests[0].amount + quests[1].amount,
                    null
                )
            ).toMutableList()
        }
        val level = LevelInfo(quests, specials)
        if (level.estimateMoves() > 20 && !LevelLists.levelList.contains(level))
            println(level.generateObjectDefinition())
        return level
    }

    private fun createBoxQuest(): LevelQuest {
        return LevelQuest(
            if (Math.random() > 0.5) SpecialType.OpenBox else SpecialType.Box,
            null,
            Random.nextInt(1, 10)
        )
    }

    private fun createMultiQuest(): LevelQuest {
        return LevelQuest(SpecialType.None, null, Random.nextInt(1, 10), Random.nextInt(5, 10))
    }

    private fun createColorQuest(): LevelQuest {
        return LevelQuest(SpecialType.None, startColor(), Random.nextInt(4, 20), null)
    }


    fun getCurrentMaxLevel(): Int {
        return sharedPreferences.getInt(CurrentLevelString, 1)
    }

    fun fillBackground() {
        _viewState.update { state ->
            val columns = mutableListOf<List<ColorField>>()
            for(i in 1..backgroundSize.width) {
                val row = mutableListOf<ColorField>()
                for(j in 1..backgroundSize.height) {
                    if ( i < state.gameField.size && j < state.gameField[i].size ){
                        row.add(state.gameField[i][j])
                    }else{
                        row.add(ColorField(colorFieldNextId++))
                    }
                }
                columns.add(row)
            }

            state.copy(
                gameField = columns,
            )
        }
    }
}

sealed class StartViewEvent {
    data object RemoveAnimationAt : StartViewEvent()

}