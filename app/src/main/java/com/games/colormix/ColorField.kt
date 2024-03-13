package com.games.colormix

import androidx.compose.ui.graphics.Color

data class ColorField(
    val id: Int,
    val color: Color = startColor(),
    val highlight: Boolean = false,
    val spawned: Boolean = true,
    val animateTo: Int
) : Comparable<ColorField> {
    override fun compareTo(other: ColorField): Int {
        return animateTo.compareTo(other.animateTo)
    }
}

// merge Colors
val mergeColors = mapOf(
    Pair(Color.Green, Color.Red) to Color.Yellow,
    Pair(Color.Green, Color.Blue) to Color.Cyan,
    Pair(Color.Blue, Color.Red) to Color.Magenta,
    Pair(Color.Yellow, Color.Blue) to Color.White,
    Pair(Color.Cyan, Color.Red) to Color.White,
    Pair(Color.Magenta, Color.Green) to Color.White,
)

fun startColor() = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan).random()

fun ColorField?.mergeAllowed(other: ColorField?): Boolean {
    if (this == null || other == null) {
        return false
    }
    return (this.color == other.color && !this.highlight && !other.highlight) ||
            (this.color != other.color && this.highlight && other.highlight)
}

fun ColorField?.merge(other: ColorField?): ColorField {
    if (this == null || other == null) {
        // Throw error
        return this?: ColorField(-1, animateTo = 0)
    }
    return if (this.highlight && other.highlight) {
        this.copy(
            highlight = false,
            color = mergeColors.getOrDefault(
                Pair(this.color, other.color),
                mergeColors.getOrDefault(Pair(other.color, this.color), Color.Black)
            )
        )
    } else {
        this.copy(highlight = true)
    }

}

