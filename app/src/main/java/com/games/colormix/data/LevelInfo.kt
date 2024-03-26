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