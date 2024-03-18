package com.games.colormix

import androidx.compose.ui.graphics.Color

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until 7).map { arrayOfNulls<ColorField?>(8).toList() },
    val animationAt: Animation? = null
)

data class Animation(val pos: Pair<Int, Int>, val color: Color)