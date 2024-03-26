package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class LevelQuest(
    val specialType: SpecialType = SpecialType.None,
    val color: Color? = null,
    val amount: Int,
    val multiBlock: Int? = null
)

fun LevelQuest.getMoveEstimation(): Int {
    if (this.specialType == SpecialType.Box || this.specialType == SpecialType.OpenBox) {
        return 0
    }
    val factor = if (this.multiBlock != null) multiBlock.toDouble() else 0.75

    return (amount * factor).toInt()
}
