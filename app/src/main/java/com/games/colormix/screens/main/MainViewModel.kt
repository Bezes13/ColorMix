package com.games.colormix.screens.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.FirebaseRepository
import com.games.colormix.constants.BOMB_GAIN_MULTI_BLOCK
import com.games.colormix.constants.ExtraBombPoints
import com.games.colormix.constants.ExtraLaserPoints
import com.games.colormix.constants.ExtraMovePoints
import com.games.colormix.constants.LEVEL_SIZE_X
import com.games.colormix.constants.LEVEL_SIZE_Y
import com.games.colormix.constants.RUBIK_GAIN_MULTI_BLOCK
import com.games.colormix.data.Animation
import com.games.colormix.data.BlockType
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.estimateMoves
import com.games.colormix.game.LevelLists
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val ioDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()

    private var levelIndex: Int = savedStateHandle.get<String>("levelIndex")?.toInt() ?: 1
    private var colorFieldNextId = 0
    private val endless = levelIndex == 0
    private val firebaseRepository = FirebaseRepository()

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
            val explodeBlock = state.gameField[pos.first][pos.second].type

            if (state.rubikCount <= 0 || explodeBlock.special) {
                return
            }
            val blocksToRemove = state.gameField.mapIndexed { column, colorFields ->
                colorFields.mapIndexed { row, colorField ->
                    if (colorField.type == explodeBlock) Pair(
                        column,
                        row
                    ) else null
                }.filterNotNull()
            }.flatten().toMutableList()
            val gameBoard = removeBlocksFromGameBoard(state.gameField, blocksToRemove)

            state.copy(
                animationAt = blocksToRemove.map { Animation(it, explodeBlock) },
                gameField = gameBoard,
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
            for (i in 1..LEVEL_SIZE_X) {
                val row = mutableListOf<ColorField>()
                for (j in 1..LEVEL_SIZE_Y) {
                    row.add(ColorField(colorFieldNextId++))
                }
                columns.add(row)
            }
            val res = placeSpecialBlockAtPosition(columns, level.specialBlocks)

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
                    type = specialBlocks.first { it.pos == Pair(index, inner) }.specialType,
                ) else item
            }
        }
    }

    private fun destroyBlock(pos: Pair<Int, Int>) {
        _viewState.update { state ->
            val explode = state.gameField[pos.first][pos.second]

            if (
                state.bombCount < 1 ||
                explode.type == BlockType.Empty ||
                explode.type == BlockType.Box ||
                explode.type == BlockType.FallingBox
            ) {
                return
            }

            val blocksToDestroy = mutableListOf(pos)
            if (explode.type == BlockType.Blocker) {
                var blocker = false
                state.gameField[pos.first].forEachIndexed { index, block ->
                    if (index > pos.second && block.type == BlockType.Blocker) {
                        blocker = true
                    }
                    if (!blocker && index > pos.second && block.type == BlockType.Empty) {
                        blocksToDestroy.add(Pair(pos.first, index))
                    }
                }
            }
            val gameBoard = removeBlocksFromGameBoard(state.gameField, blocksToDestroy)

            state.copy(
                animationAt = state.animationAt.plus(Animation(pos, explode.type)),
                gameField = gameBoard,
                bombCount = state.bombCount - 1,
            )
        }
    }

    private fun fillEmptySpace(gameField: List<List<ColorField?>>): List<List<ColorField>> {
        return gameField.map { columns ->
            var fromTop = true
            columns.map { item ->
                if (item == null && fromTop) {
                    ColorField(colorFieldNextId++)
                } else {
                    fromTop = false
                    item ?: ColorField(colorFieldNextId++, type = BlockType.Empty)
                }
            }
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
            val blockCount =
                blocksToDestroy.filter { pos -> !state.gameField[pos.first][pos.second].type.special }.size
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
                        Animation(it, field.type)
                    }
                ),
                gameField = gameBoard,
                dialog = if (updatedQuests.all { it.amount <= 0 } && !endless) MainViewDialog.LevelComplete(
                    levelIndex.toString(),
                    state.currentLevel.moves,
                    state.bombCount,
                    state.rubikCount
                ) else if (state.currentLevel.moves <= 1 && !endless)
                    MainViewDialog.LevelFailed else if (state.rubikCount == 0 && state.bombCount == 0 && noMovesAvailable(
                        gameBoard
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
                        if ((quest.multiBlock != null) && (quest.multiBlock <= blockCount)) {
                            quest.amount - 1
                        } else {
                            quest.amount - blocksToDestroy.filter { pos ->
                                state.gameField[pos.first][pos.second].type == quest.block
                            }.size

                        }
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
            newPoints += state.currentLevel.moves * ExtraMovePoints +
                    state.bombCount * ExtraBombPoints +
                    state.rubikCount * ExtraLaserPoints
            viewModelScope.launch {
                firebaseRepository.addOrUpdateScore(newPoints, levelIndex)
            }
        }
        return newPoints
    }


    private fun noMovesAvailable(gameField: List<List<ColorField>>): Boolean {
        gameField.forEachIndexed { column, colorFields ->
            colorFields.forEachIndexed { row, colorField ->
                if (!colorField.type.special) {
                    if (gameField[column].size > row + 1 && colorField.type == gameField[column][row + 1].type) {
                        return false
                    }
                    if (gameField.size > column + 1 && colorField.type == gameField[column + 1][row].type) {
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
    ): List<List<ColorField>> {

        val gameField = gameBoard.mapIndexed { column, colorFields ->
            colorFields.mapIndexed { row, colorField ->
                if (colorField == null) {
                    null
                } else
                    if (blocksToDestroy.contains(Pair(column, row))
                    ) {
                        if (colorField.type == BlockType.Box)
                            colorField.copy(type = BlockType.FallingBox) else null
                    } else {
                        colorField
                    }
            }
        }

        val columns = mutableListOf<List<ColorField?>>()
        gameField.forEach {
            columns.add(pushBlocksDown(it.toMutableList()))
        }

        return fillEmptySpace(columns)
    }

    private fun getBlocksToDestroy(
        blocksToDestroy: MutableList<Pair<Int, Int>>,
        pos: Pair<Int, Int>,
        board: List<List<ColorField>>
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
                if (list[i] != null &&
                    list[i]?.type != BlockType.Blocker &&
                    (list[i + 1] == null)
                )//|| (list[i + 1]?.type == BlockType.Empty)))
                {
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

    private fun isDestroyable(
        pos: Pair<Int, Int>,
        fieldsToDestroy: MutableList<Pair<Int, Int>>,
        board: List<List<ColorField>>
    ): Boolean {
        val field = board[pos.first][pos.second]
        if (field.type.special) {
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
        return fieldsToDestroy.filter { !board[it.first][it.second].type.special }.size > 1
    }

    private fun hasSameColor(pair: Pair<Int, Int>, field: ColorField?): Pair<Int, Int>? {
        val gameBoard = _viewState.value.gameField

        return if (field != null &&
            pair.first >= 0 &&
            pair.second >= 0 &&
            pair.first < gameBoard.size &&
            pair.second < gameBoard[pair.first].size && (gameBoard[pair.first][pair.second].type == field.type ||
                    gameBoard[pair.first][pair.second].type == BlockType.Box ||
                    gameBoard[pair.first][pair.second].type == BlockType.FallingBox)
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