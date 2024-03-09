package com.games.colormix

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField?>> = (0 until 4).map { arrayOfNulls<ColorField?>(4).toList() }
)