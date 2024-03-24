package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class LevelQuest(
    val specialType: SpecialType = SpecialType.None,
    val color: Color? = null,
    val amount: Int,
    val multiBlock: Int? = null
)

fun LevelQuest.getMoveEstimation(): Int{
    var factor = 0.8
    if (this.specialType== SpecialType.Box){
        factor = 2.0
    }
    if (this.specialType== SpecialType.OpenBox){
        factor = 1.0
    }
    if (this.multiBlock != null){
        factor = multiBlock/2.0
    }
    return (amount*factor).toInt()
}
