package com.games.colormix.main

import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.game.LevelData
import com.games.colormix.game.LevelInfo

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until 7).map { arrayOfNulls<ColorField?>(8).toList() },
    val animationAt: Animation? = null,
    val currentLevel: LevelInfo = LevelData.LEVELS[7],
    val points: Int = 0
)

