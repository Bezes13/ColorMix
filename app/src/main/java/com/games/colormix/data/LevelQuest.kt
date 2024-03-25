package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class LevelQuest(
    val specialType: SpecialType = SpecialType.None,
    val color: Color? = null,
    val amount: Int,
    val multiBlock: Int? = null
)

fun LevelQuest.getMoveEstimation(): Int{
    var factor = 1
    if (this.specialType== SpecialType.Box){
        factor = 2
    }
    if (this.specialType== SpecialType.OpenBox){
        factor = 1
    }
    if (this.multiBlock != null){
        factor = multiBlock
    }
    return (amount*factor)
}
