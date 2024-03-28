package com.games.colormix.data

import androidx.compose.ui.graphics.Color

data class LevelInfo(
    val quests: List<LevelQuest> = listOf(),
    val specialBlocks: List<SpecialBlockPlacement> = listOf(),
    val moves: Int = 100,
    val level: Int = 100
)

fun LevelInfo.generateObjectDefinition(): String {
    val questsString = this.quests.joinToString(prefix = "listOf(", postfix = ")") {
        "LevelQuest(SpecialType.${it.specialType}, ${it.color.getColorName()}, ${it.amount}, ${it.multiBlock})"
    }
    val specialBlocksString =
        this.specialBlocks.joinToString(prefix = "listOf(", postfix = ")") {
            "SpecialBlockPlacement(SpecialType.${it.specialType}, Pair(${it.pos.first},${it.pos.second}))"
        }
    return """
        LevelInfo(
            quests = $questsString,
            specialBlocks = $specialBlocksString
        ),
    """.trimIndent()
}

fun LevelInfo.estimateMoves(): Int {
    var moves = 1
    this.quests.forEach { moves += it.getMoveEstimation() }
    moves += this.specialBlocks.filter { it.specialType == SpecialType.Rock }.size
    moves += (this.specialBlocks.filter { it.specialType == SpecialType.Box }.size * 1.5).toInt()
    moves += (this.specialBlocks.filter { it.specialType == SpecialType.OpenBox }.size * 1)
    return moves
}

fun Color?.getColorName(): String {
    return when (this) {
        Color.Red -> "Color.Red"
        Color.Yellow -> "Color.Yellow"
        Color.Green -> "Color.Green"
        Color.Blue -> "Color.Blue"
        Color.Cyan -> "Color.Cyan"
        else -> {
            "null"
        }
    }
}