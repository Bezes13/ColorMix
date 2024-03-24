package com.games.colormix.game

import androidx.compose.ui.graphics.Color
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType

data class LevelInfo(
    val quests: List<LevelQuest> = listOf(),
    val specialBlocks: List<SpecialBlockPlacement> = listOf(),
    val moves: Int,
    val level: Int = 100
)

fun generateObjectDefinition(levelInfo: LevelInfo): String {
    val questsString = levelInfo.quests.joinToString(prefix = "listOf(", postfix = ")") {
        "LevelQuest(SpecialType.${it.specialType}, Color.${getColorName(it.color)}, ${it.amount}, ${it.multiBlock})"
    }
    val specialBlocksString =
        levelInfo.specialBlocks.joinToString(prefix = "listOf(", postfix = ")") {
            "SpecialBlockPlacement(SpecialType.${it.specialType}, Pair(${it.pos.first},${it.pos.second}))"
        }
    return """
        LevelInfo(
            quests = $questsString,
            specialBlocks = $specialBlocksString,
            moves = ${levelInfo.moves}
        ),
    """.trimIndent()
}

fun getColorName(color: Color?): String {

    return when (color) {
        Color.Red -> "Red"
        Color.Yellow -> "Yellow"
        Color.Green -> "Green"
        Color.Blue -> "Blue"
        Color.Cyan -> "Cyan"
        else -> {
            "Transparent"
        }
    }
}

object LevelData {
    val LEVELS = listOf(
        // Level 1
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Green, 6)),
            moves = 6
        ),
        // Level 2
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Red, 8)),
            moves = 7
        ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 1, multiBlock = 4)),
            specialBlocks = listOf(),
            moves = 6
        ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 2, multiBlock = 5)),
            specialBlocks = listOf(),
            moves = 6
        ),
        // Level 3
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Yellow, 10)),
            moves = 8
        ),
        // Level 4
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Cyan, 12)),
            moves = 10
        ),
        // Level 5
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Blue, 15)),
            moves = 12
        ),
        // Level 6
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 15),
                LevelQuest(SpecialType.None, Color.Red, 15)
            ),
            moves = 15
        ),
        // Level 7
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 15),
                LevelQuest(SpecialType.None, Color.Cyan, 15)
            ),
            moves = 15
        ),
        // Level 8
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Yellow, 15),
                LevelQuest(SpecialType.None, Color.Green, 15)
            ),
            moves = 20
        ),
        // Level 9
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 20),
                LevelQuest(SpecialType.None, Color.Cyan, 20)
            ),
            moves = 25
        ),
        // Level 10
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 2)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5))
            ),
            moves = 5
        ),
        // Level 11
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 7))
            ),
            moves = 15
        ),
        // Level 12
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 7))
            ),
            moves = 20
        ),
        // Level 13
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 7))
            ),
            moves = 20
        ),
        // Level 14
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 7)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 0))
            ),
            moves = 20
        ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 1)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4))
            ),
            moves = 5
        ),

        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 1, multiBlock = 6)),
            specialBlocks = listOf(),
            moves = 6
        ),
        // Level 16
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 2)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4))
            ),
            moves = 7
        ),
        // Level 17
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 3)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4))
            ),
            moves = 9
        ),
        // Level 18
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 4)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(6, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 4))
            ),
            moves = 12
        ),
        // Level 18
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 3)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(6, 0))
            ),
            moves = 100
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 4, null),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2))
            ),
            moves = 7
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 14, null),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 0))
            ),
            moves = 20
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 8, 6),
                LevelQuest(SpecialType.None, Color.Red, 16, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0))
            ),
            moves = 36
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 17, null),
                LevelQuest(SpecialType.None, Color.Blue, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5))
            ),
            moves = 17
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 9, null),
                LevelQuest(SpecialType.None, Color.Green, 16, null),
                LevelQuest(SpecialType.None, null, 7, 7)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4))
            ),
            moves = 45
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 1, 5),
                LevelQuest(SpecialType.OpenBox, null, 2, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3))
            ),
            moves = 4
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 3, null),
                LevelQuest(SpecialType.None, null, 9, 7)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 2))
            ),
            moves = 37
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 11, null),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0))
            ),
            moves = 16
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 5, null),
                LevelQuest(SpecialType.None, null, 1, 5),
                LevelQuest(SpecialType.None, Color.Green, 8, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 6))
            ),
            moves = 13
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 9, null),
                LevelQuest(SpecialType.OpenBox, null, 4, null),
                LevelQuest(SpecialType.None, Color.Cyan, 15, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6))
            ),
            moves = 27
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Red, 9, null),
                LevelQuest(SpecialType.None, null, 4, 8)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0))
            ),
            moves = 23
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 4, null),
                LevelQuest(SpecialType.OpenBox, null, 3, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 0))
            ),
            moves = 6
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Green, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0))
            ),
            moves = 4
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 5, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),
            moves = 20
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 8, 9),
                LevelQuest(SpecialType.OpenBox, null, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3))
            ),
            moves = 42
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Red, 12, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 2))
            ),
            moves = 9
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 9, null)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5))),
            moves = 7
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 9, 7),
                LevelQuest(SpecialType.None, Color.Red, 7, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4))
            ),
            moves = 36
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 2))
            ),
            moves = 4
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 7, null),
                LevelQuest(SpecialType.None, Color.Blue, 15, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),
            moves = 26
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Red, 19, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5))
            ),
            moves = 15
        ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 5, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3))
            ),
            moves = 5
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 1, 8),
                LevelQuest(SpecialType.OpenBox, null, 4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3))
            ),
            moves = 12
        )

    )
}
