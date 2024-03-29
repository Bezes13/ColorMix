package com.games.colormix.main

import com.games.colormix.constants.LEVEL_SIZE_X
import com.games.colormix.constants.LEVEL_SIZE_Y
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelInfo
import com.games.colormix.game.LevelData

data class MainViewState(
    val isLoading: Boolean = false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until LEVEL_SIZE_X).map {
        arrayOfNulls<ColorField?>(
            LEVEL_SIZE_Y
        ).toList()
    },
    val animationAt: List<Animation> = listOf(),
    val currentLevel: LevelInfo = LevelData.LEVEL_GROUP1[7],
    val points: Int = 0,
    val bombCount: Int = 1,
    val rubikCount: Int = 1,
    val blocksAcc: Int = 0
)

