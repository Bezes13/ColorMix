package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class LevelQuest(
    val specialType: SpecialType = SpecialType.None,
    val color: Color? = null,
    val amount: Int
)
