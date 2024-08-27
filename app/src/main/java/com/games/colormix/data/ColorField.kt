package com.games.colormix.data

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

enum class BlockType(val drawId:Int,val special: Boolean){
    Earth(R.drawable.earth, false),
    Mercury(R.drawable.merkur, false),
    Moon(R.drawable.moon, false),
    Saturn(R.drawable.saturn, false),
    Uranus(R.drawable.uranus, false),
    Blocker(R.drawable.alien, true),
    Box(R.drawable.sonde, true),
    FallingBox(R.drawable.sonde2, true),
    Empty(R.drawable.solar, true)
}
