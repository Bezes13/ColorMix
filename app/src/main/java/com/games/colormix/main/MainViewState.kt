package com.games.colormix.main

import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.game.LevelData
import com.games.colormix.game.LevelInfo

val LEVELSIZE = Pair(7, 8)

data class MainViewState(
    val isLoading: Boolean = false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until LEVELSIZE.first).map {
        arrayOfNulls<ColorField?>(
            LEVELSIZE.second
        ).toList()
    },
    val animationAt: List<Animation> = listOf(),
    val currentLevel: LevelInfo = LevelData.LEVELS[7],
    val points: Int = 0,
    val bombCount: Int = 1,
    val rubikCount: Int = 1
)

