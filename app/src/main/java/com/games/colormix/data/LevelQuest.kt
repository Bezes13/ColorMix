package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class LevelQuest(
    val specialType: SpecialType = SpecialType.None,
    val color: Color? = null,
    val amount: Int,
    val multiBlock: Int? = null
)

fun LevelQuest.getMoveEstimation(): Int{
    var factor = 0.75
    if (this.specialType== SpecialType.Box){
        factor = 0.0
    }
    if (this.specialType== SpecialType.OpenBox){
        factor = 0.0
    }
    if (this.multiBlock != null){
        factor = multiBlock.toDouble()
    }
    return (amount*factor).toInt()
}
