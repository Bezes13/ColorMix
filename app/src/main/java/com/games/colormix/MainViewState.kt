package com.games.colormix

import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until 7).map { arrayOfNulls<ColorField?>(8).toList() },
    val animationAt: Animation? = null,
    val currentLevel: LevelInfo = LevelData.LEVELS[7]
)

