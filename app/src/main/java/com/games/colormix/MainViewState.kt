package com.games.colormix

data class MainViewState (
    val isLoading: Boolean= false,
    val dialog: MainViewDialog = MainViewDialog.None
)