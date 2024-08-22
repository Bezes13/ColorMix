package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class ColorField(
    val id: Int,
    val color: Color? = startColor(),
    val specialType: SpecialType = SpecialType.None,
)

enum class SpecialType {
    None, Rock, Box, OpenBox
}

val startColors = listOf(Color.Yellow, Color.Green, Color.Blue, Color.Red, Color.Cyan)

fun startColor() = startColors.random()

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