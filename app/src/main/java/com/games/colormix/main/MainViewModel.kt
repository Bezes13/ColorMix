package com.games.colormix.main

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.constants.BOMB_GAIN_MULTI_BLOCK
import com.games.colormix.constants.RUBIK_GAIN_MULTI_BLOCK
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType
import com.games.colormix.data.estimateMoves
import com.games.colormix.data.putOnRightPositionAfterAnimation
import com.games.colormix.game.LevelData
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
    private var levelIndex: Int = savedStateHandle.get<String>("levelIndex")?.toInt() ?: 0
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

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
            val explode = state.gameField[pos.first][pos.second]?.color

            if (state.rubikCount <= 0 || explode == null) {
                return
            }
            val list = state.gameField.mapIndexed { column, colorFields ->
                colorFields.mapIndexed { row, colorField ->
                    if (colorField?.color == explode) Pair(
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

            placeNewBlocks(columns)

            state.copy(
                animationAt = list.map { Animation(it, explode) },
                gameField = gameBoard.mapIndexed { index, colorFields ->
                    colorFields.map { colorField -> colorField?.copy(animateTo = columns[index].indexOfFirst { it?.id == colorField.id }) }
                },
                rubikCount = state.rubikCount - 1,
                dialog = if (state.currentLevel.moves <= 1)
                    MainViewDialog.LevelFailed else MainViewDialog.None,
            )
        }
    }

    private fun retryLevel() {
        fillGameField()
        letTheBlocksFall()
    }

    private fun updateToNextLevel() {
        levelIndex += 1
        fillGameField()
        letTheBlocksFall()
    }

    private fun removeAnimationAt(pos: Pair<Int, Int>) {
        _viewState.update { state -> state.copy(animationAt = state.animationAt.filter { it.pos != pos }) }
    }

    private fun fillGameField() {
        if (levelIndex >= LevelData.LEVELS.size) {
            _viewState.update { state ->
                state.copy(
                    currentLevel = state.currentLevel.copy(level = levelIndex),
                )
            }
            return
        }
        val level = LevelData.LEVELS[levelIndex]
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
                level.specialBlocks
            )

            val moves = level.estimateMoves()
            state.copy(
                gameField = res,
                currentLevel = level.copy(level = levelIndex + 1, moves = moves),
                points = 0,
                bombCount = 0,
                rubikCount = 0,
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

            if (explode != null && (state.bombCount < 1 || explode.specialType == SpecialType.Box || explode.specialType == SpecialType.OpenBox)) {
                return
            }
            val gameBoard = removeBlocksFromGameBoard(state.gameField, mutableListOf(pos))

            val columns = mutableListOf<List<ColorField?>>()
            for (i in gameBoard.indices) {
                columns.add(pushBlocksDown(gameBoard[i].toMutableList()))
            }

            placeNewBlocks(columns)

            state.copy(
                animationAt = state.animationAt.plus(Animation(pos, Color.Black)),
                gameField = gameBoard.mapIndexed { index, colorFields ->
                    colorFields.map { colorField -> colorField?.copy(animateTo = columns[index].indexOfFirst { it?.id == colorField.id }) }
                },
                bombCount = state.bombCount - 1,
                dialog = if (state.currentLevel.moves <= 1)
                    MainViewDialog.LevelFailed else MainViewDialog.None,
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

            val blockCount = blocksToDestroy.filter { pos -> state.gameField[pos.first][pos.second]?.specialType == SpecialType.None }.size
            val updatedQuests = updateQuests(state, blockCount, blocksToDestroy)
            placeNewBlocks(columns)
            val newPoints = getPointsAndSaveOnLevelDone(state, blockCount, updatedQuests)
            state.copy(
                currentLevel = state.currentLevel.copy(
                    moves = state.currentLevel.moves - 1,
                    quests = updatedQuests
                ),
                animationAt = state.animationAt.plus(
                    Animation(
                        pos,
                        field?.color ?: Color.Transparent
                    )
                ),
                gameField = gameBoard.mapIndexed { index, colorFields ->
                    colorFields.map { colorField -> colorField?.copy(animateTo = columns[index].indexOfFirst { it?.id == colorField.id }) }
                },
                dialog = if (updatedQuests.all { it.amount <= 0 }) MainViewDialog.LevelComplete(
                    levelIndex.toString()
                ) else if (state.currentLevel.moves <= 1)
                    MainViewDialog.LevelFailed else MainViewDialog.None,
                points = newPoints,
                bombCount = if (blockCount >= BOMB_GAIN_MULTI_BLOCK) state.bombCount + 1 else state.bombCount,
                rubikCount = if (blockCount >= RUBIK_GAIN_MULTI_BLOCK) state.rubikCount + 1 else state.rubikCount
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
                            quest.amount - blocksToDestroy.filter { pos -> state.gameField[pos.first][pos.second]?.specialType == quest.specialType && state.gameField[pos.first][pos.second]?.color == quest.color }.size
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

    // Place the animated Fields in the correct Spot
    // Add new ColorFields in empty fields
    private fun updateBlocksAfterAnimation() {
        _viewState.update {
            val newGameField = it.gameField.map { colorFields ->
                var fromTop = true
                colorFields.putOnRightPositionAfterAnimation().mapIndexed { idx, item ->
                    if (item == null && fromTop) {
                        ColorField(colorFieldNextId++, animateTo = idx)
                    } else {
                        fromTop = false
                        item
                    }
                }
            }
            it.copy(
                dialog = if (noMovesAvailable(newGameField)) MainViewDialog.NoMovesAvailable else it.dialog,
                gameField = newGameField
            )
        }
        letTheBlocksFall()
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

    private fun letTheBlocksFall() {
        viewModelScope.launch(ioDispatcher) {
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
            viewModelScope.launch(ioDispatcher) {
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
    data class RemoveAnimationAt(val pos: Pair<Int, Int>) : MainViewEvent()
    data class UseBomb(val pos: Pair<Int, Int>) : MainViewEvent()
    data class UseRubiks(val pos: Pair<Int, Int>) : MainViewEvent()
    data object SetBlocksAfterAnimation : MainViewEvent()
    data object NextLevel : MainViewEvent()
    data object Retry : MainViewEvent()
}