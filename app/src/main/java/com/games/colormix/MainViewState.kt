package com.games.colormix

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until 7).map { arrayOfNulls<ColorField?>(8).toList() },
    val animationAt: Pair<Int, Int>? = null
)