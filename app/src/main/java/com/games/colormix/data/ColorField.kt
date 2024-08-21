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
