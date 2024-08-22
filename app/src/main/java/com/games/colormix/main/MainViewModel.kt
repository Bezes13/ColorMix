package com.games.colormix.main

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.constants.BOMB_GAIN_MULTI_BLOCK
import com.games.colormix.constants.LEVEL_SIZE_X
import com.games.colormix.constants.RUBIK_GAIN_MULTI_BLOCK
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType
import com.games.colormix.data.estimateMoves
import com.games.colormix.game.LevelLists
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.max

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val ioDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()
    private var colorFieldNextId = 0
    private var levelIndex: Int = savedStateHandle.get<String>("levelIndex")?.toInt() ?: 1
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    private val endless = levelIndex == 0

    init {
        listenToEvent()
        fillGameField()
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
                is MainViewEvent.RemoveAnimationAt -> removeAnimationAt(event.pos)
                is MainViewEvent.NextLevel -> updateToNextLevel()
                is MainViewEvent.Retry -> retryLevel()
                is MainViewEvent.UseBomb -> destroyBlock(event.pos)
                is MainViewEvent.UseRubiks -> destroyColor(event.pos)
            }
        }
    }

    private fun destroyColor(pos: Pair<Int, Int>) {
        _viewState.update { state ->
            val explode = state.gameField[pos.first][pos.second].color

            if (state.rubikCount <= 0 || explode == null) {
                return
            }
            val list = state.gameField.mapIndexed { column, colorFields ->
                colorFields.mapIndexed { row, colorField ->
                    if (colorField.color == explode) Pair(
                        column,
                        row
                    ) else null
                }.filterNotNull()
            }.flatten()
                .toMutableList()
            val gameBoard = removeBlocksFromGameBoard(state.gameField, list)

            val columns = mutableListOf<List<ColorField?>>()
            for (i in gameBoard.indices) {
                columns.add(pushBlocksDown(gameBoard[i].toMutableList()))
            }

            state.copy(
                animationAt = list.map { Animation(it, explode) },
                gameField = columns.map {
                    it.map { block ->
                        block ?: ColorField(colorFieldNextId++)
                    }
                },
                rubikCount = state.rubikCount - 1
            )
        }
    }

    private fun retryLevel() {
        fillGameField()
    }

    private fun updateToNextLevel() {
        levelIndex += 1
        fillGameField()
    }

    private fun removeAnimationAt(pos: Pair<Int, Int>) {
        _viewState.update { state -> state.copy(animationAt = state.animationAt.filter { it.pos != pos }) }
    }

    private fun fillGameField() {
        if (levelIndex >= LevelLists.levelList.size) {
            _viewState.update { state ->
                state.copy(
                    currentLevel = state.currentLevel.copy(level = levelIndex),
                )
            }
            return
        }
        val level = LevelLists.levelList[levelIndex]
        _viewState.update { state ->
            val columns = mutableListOf<List<ColorField>>()
            for(i in 1..LEVEL_SIZE_X) {
                val row = mutableListOf<ColorField>()
                for(j in 1..LEVEL_SIZE_X) {
                    row.add(ColorField(colorFieldNextId++))
                }
                columns.add(row)
            }
            val res = placeSpecialBlockAtPosition(
                columns,
                level.specialBlocks
            )

            val moves = level.estimateMoves()
            state.copy(
                gameField = res,
                currentLevel = level.copy(level = levelIndex, moves = moves),
                points = 0,
                bombCount = 0,
                rubikCount = 0,
                blocksAcc = 0,
                dialog = MainViewDialog.None
            )
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

    private fun destroyBlock(pos: Pair<Int, Int>) {
        _viewState.update { state ->
            val explode = state.gameField[pos.first][pos.second]

            if (state.bombCount < 1 || explode.specialType == SpecialType.Box || explode.specialType == SpecialType.OpenBox) {
                return
            }
            val gameBoard = removeBlocksFromGameBoard(state.gameField, mutableListOf(pos))

            val columns = mutableListOf<List<ColorField?>>()
            for (i in gameBoard.indices) {
                columns.add(pushBlocksDown(gameBoard[i].toMutableList()))
            }

            state.copy(
                animationAt = state.animationAt.plus(Animation(pos, Color.Black)),
                gameField = columns.map {
                    it.map { block ->
                        block ?: ColorField(colorFieldNextId++)
                    }
                },
                bombCount = state.bombCount - 1,
            )
        }
    }

    private fun blockClicked(pos: Pair<Int, Int>) {
        _viewState.update { state ->
            val blocksToDestroy = mutableListOf<Pair<Int, Int>>()
            val field = state.gameField[pos.first][pos.second]
            if (!getBlocksToDestroy(blocksToDestroy, pos, state.gameField)) {
                return
            }
            val gameBoard = removeBlocksFromGameBoard(state.gameField, blocksToDestroy)

            val columns = mutableListOf<List<ColorField?>>()
            for (i in gameBoard.indices) {
                columns.add(pushBlocksDown(gameBoard[i].toMutableList()))
            }
            val newField:List<List<ColorField>> = columns.map {
                it.map { block ->
                    block ?: ColorField(colorFieldNextId++)
                }
            }

            val blockCount =
                blocksToDestroy.filter { pos -> state.gameField[pos.first][pos.second].specialType == SpecialType.None }.size
            val updatedQuests = updateQuests(state, blockCount, blocksToDestroy)

            val newPoints = getPointsAndSaveOnLevelDone(state, blockCount, updatedQuests)
            val blocksAcc = state.blocksAcc + blockCount
            state.copy(
                currentLevel = state.currentLevel.copy(
                    moves = if (endless) state.currentLevel.moves + 1 else state.currentLevel.moves - 1,
                    quests = updatedQuests
                ),
                animationAt = state.animationAt.plus(
                    blocksToDestroy.map {
                        Animation(
                            it,
                            field.color ?: Color.Transparent
                        )
                    }
                ),
                gameField = newField,
                dialog = if (updatedQuests.all { it.amount <= 0 } && !endless) MainViewDialog.LevelComplete(
                    levelIndex.toString()
                ) else if (state.currentLevel.moves <= 1 && !endless)
                    MainViewDialog.LevelFailed else if (state.rubikCount == 0 && state.bombCount == 0 && noMovesAvailable(
                        columns
                    )
                ) MainViewDialog.NoMovesAvailable else
                    MainViewDialog.None,
                points = newPoints,
                bombCount = if (blockCount >= BOMB_GAIN_MULTI_BLOCK) state.bombCount + 1 else state.bombCount,
                rubikCount = if (blocksAcc >= RUBIK_GAIN_MULTI_BLOCK) state.rubikCount + 1 else state.rubikCount,
                blocksAcc = if (blocksAcc >= RUBIK_GAIN_MULTI_BLOCK) blocksAcc - RUBIK_GAIN_MULTI_BLOCK else blocksAcc
            )
        }
    }

    private fun updateQuests(
        state: MainViewState,
        blockCount: Int,
        blocksToDestroy: MutableList<Pair<Int, Int>>
    ): List<LevelQuest> {
        val updatedQuests =
            state.currentLevel.quests.map { quest ->
                quest.copy(
                    amount = max(
                        0,
                        if ((quest.multiBlock != null) && (quest.multiBlock <= blockCount)) quest.amount - 1 else
                            quest.amount - blocksToDestroy.filter { pos -> state.gameField[pos.first][pos.second].specialType == quest.specialType && state.gameField[pos.first][pos.second].color == quest.color }.size
                    )
                )
            }
        return updatedQuests
    }

    private fun getPointsAndSaveOnLevelDone(
        state: MainViewState,
        blockCount: Int,
        updatedQuests: List<LevelQuest>
    ): Int {
        var newPoints = state.points + blockCount * 50 * blockCount
        if (updatedQuests.all { it.amount <= 0 }) {
            val editor = sharedPreferences.edit()
            if (sharedPreferences.getInt("currentLevel", 0) < levelIndex + 1) {
                editor.putInt("currentLevel", levelIndex + 1)
            }
            if (sharedPreferences.getInt("LEVEL$levelIndex", 0) < newPoints) {
                newPoints =
                    state.points + blockCount * 50 * blockCount + state.currentLevel.moves * 1000
                editor.putInt("LEVEL$levelIndex", newPoints)
            }
            editor.apply()
        }
        return newPoints
    }


    private fun noMovesAvailable(gameField: List<List<ColorField?>>): Boolean {
        gameField.forEachIndexed { column, colorFields ->
            colorFields.forEachIndexed { row, colorField ->
                if (colorField?.specialType == SpecialType.None) {
                    if (gameField[column].size > row + 1 && colorField.color == gameField[column][row + 1]?.color) {
                        return false
                    }
                    if (gameField.size > column + 1 && colorField.color == gameField[column + 1][row]?.color) {
                        return false
                    }
                }
            }
        }
        return true
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

    private fun pushBlocksDown(list: MutableList<ColorField?>): List<ColorField?> {
        // [B, null, G, Null] -> [null, null, B, G]
        var anyMove = true
        while (anyMove) {
            anyMove = false
            for (i in 0..<list.size - 1) {
                if (list[i] != null && list[i]?.specialType != SpecialType.Rock && list[i + 1] == null) {
                    anyMove = true
                    list[i + 1] = list[i]
                    list[i] = null
                }
            }
        }
        return list
    }

    private fun updateDialog(dialog: MainViewDialog) {
        _viewState.update { it.copy(dialog = dialog) }
    }

    fun isTutorialShown(): Boolean {
        return sharedPreferences.getInt("tutorial", 0) == 1
    }

    fun setTutorialShown() {
        val editor = sharedPreferences.edit()
        editor.putInt("tutorial", 1)
        editor.apply()
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
        return fieldsToDestroy.filter { board[it.first][it.second]?.specialType == SpecialType.None }.size > 1
    }

    private fun hasSameColor(pair: Pair<Int, Int>, field: ColorField?): Pair<Int, Int>? {
        val gameBoard = _viewState.value.gameField

        return if (field != null &&
                pair.first >= 0 &&
                pair.second >= 0 &&
                pair.first < gameBoard.size &&
                pair.second < gameBoard[pair.first].size && (gameBoard[pair.first][pair.second].color == field.color ||
                    gameBoard[pair.first][pair.second].specialType == SpecialType.Box ||
                    gameBoard[pair.first][pair.second].specialType == SpecialType.OpenBox)
        )
            pair else null
    }
}

sealed class MainViewEvent {
    data class SetDialog(val dialog: MainViewDialog) : MainViewEvent()
    data class FieldClicked(val pos: Pair<Int, Int>) : MainViewEvent()
    data class RemoveAnimationAt(val pos: Pair<Int, Int>) : MainViewEvent()
    data class UseBomb(val pos: Pair<Int, Int>) : MainViewEvent()
    data class UseRubiks(val pos: Pair<Int, Int>) : MainViewEvent()
    data object NextLevel : MainViewEvent()
    data object Retry : MainViewEvent()
}