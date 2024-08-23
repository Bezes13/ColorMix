package com.games.colormix.main

import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelInfo

data class MainViewState(
    val isLoading: Boolean = false,
    val dialog: MainViewDialog = MainViewDialog.None,
    val gameField: List<List<ColorField>> = listOf(),
    val animationAt: List<Animation> = listOf(),
    val currentLevel: LevelInfo = LevelInfo(),
    val points: Int = 0,
    val bombCount: Int = 1,
    val rubikCount: Int = 1,
    val blocksAcc: Int = 0
)

