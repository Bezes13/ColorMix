package com.games.colormix

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: Array<Array<ColorField?>> = Array(4) { Array(4) { null } }
)