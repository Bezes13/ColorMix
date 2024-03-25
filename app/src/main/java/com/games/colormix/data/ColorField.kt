package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class ColorField(
    val id: Int,
    val color: Color? = startColor(),
    val highlight: Boolean = false,
    val spawned: Boolean = true,
    val dropped: Boolean = true,
    val specialType: SpecialType = SpecialType.None,
    val animateTo: Int
) : Comparable<ColorField> {
    override fun compareTo(other: ColorField): Int {
        return animateTo.compareTo(other.animateTo)
    }
}

enum class SpecialType {
    None, Rock, Box, OpenBox
}

val startColors = listOf(Color.Yellow, Color.Green, Color.Blue, Color.Red, Color.Cyan)

fun startColor() = startColors.random()

fun List<ColorField?>.putOnRightPositionAfterAnimation(): MutableList<ColorField?> {
    val result = arrayOfNulls<ColorField?>(8).toMutableList()
    this.forEachIndexed { _, it ->
        if (it != null) {
            result[it.animateTo] = it
        }
    }
    return result
}

