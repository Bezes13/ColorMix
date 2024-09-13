package com.games.colormix.data

import androidx.compose.ui.graphics.Color
import com.games.colormix.R

data class ColorField(
    val id: Int,
    val type: BlockType = randomBlock(),
)

fun randomBlock() = BlockType.entries.filter { !it.special }.random()

fun pushBlocksDown(list: MutableList<ColorField?>): List<ColorField?> {
    // [B, null, G, Null] -> [null, null, B, G]
    var anyMove = true
    while (anyMove) {
        anyMove = false
        for (i in 0..<list.size - 1) {
            if (list[i] != null && list[i + 1] == null) {
                anyMove = true
                list[i + 1] = list[i]
                list[i] = null
            }
        }
    }
    return list
}

enum class BlockType(val drawId:Int,val special: Boolean, val simpleDesign: Color){
    Earth(R.drawable.earth, false, Color.Red),
    Mercury(R.drawable.merkur, false, Color.Blue),
    Moon(R.drawable.moon, false, Color.Cyan),
    Saturn(R.drawable.saturn, false, Color.Green),
    Uranus(R.drawable.uranus, false, Color.Yellow),
    Blocker(R.drawable.alien, true, Color.Transparent),
    Box(R.drawable.box, true, Color.Transparent),
    FallingBox(R.drawable.boxopen, true, Color.Transparent),
    Empty(R.drawable.solar, true, Color.Transparent)
}
