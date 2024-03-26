package com.games.colormix.game

import androidx.compose.ui.graphics.Color
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType

object LevelData {
    val LEVELS = listOf(
        // Level 1
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Green, 6))
        ),
        // Level 2
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Red, 8)),

            ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 1, multiBlock = 4)),
            specialBlocks = listOf(),

            ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 2, multiBlock = 5)),
            specialBlocks = listOf(),

            ),
        // Level 3
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Yellow, 10)),
        ),
        // Level 4
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Cyan, 12)),

            ),
        // Level 5
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Blue, 15)),

            ),
        // Level 6
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 15),
                LevelQuest(SpecialType.None, Color.Red, 15)
            ),

            ),
        // Level 7
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 15),
                LevelQuest(SpecialType.None, Color.Cyan, 15)
            ),

            ),
        // Level 8
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Yellow, 15),
                LevelQuest(SpecialType.None, Color.Green, 15)
            ),
        ),
        // Level 9
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 20),
                LevelQuest(SpecialType.None, Color.Cyan, 20)
            ),
        ),
        // Level 10
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 2)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5))
            ),
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
        ),
        // Level 12
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 7))
            ),
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
        ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 1)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4))
            ),
        ),

        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 1, multiBlock = 6)),
            specialBlocks = listOf(),
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

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 9, null),
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

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 5, null),
                LevelQuest(SpecialType.None, null, 1, 5),
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

            ),
        LevelInfo(
            quests = listOf(
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
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)))
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
            )
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

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 5, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),

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

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Red, 12, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 9, null)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5))),

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

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 2))
            ),

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

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Red, 19, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5))
            ),

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

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 1, null),
                LevelQuest(SpecialType.None, Color.Green, 7, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 6, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 2, 7),
                LevelQuest(SpecialType.None, Color.Green, 6, null)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(3, 2))),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 5, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 4, null),
                LevelQuest(SpecialType.OpenBox, null, 9, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 8, null),
                LevelQuest(SpecialType.None, null, 7, 9)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 2, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Yellow, 11, null),
                LevelQuest(SpecialType.None, null, 4, 5)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 1, 6)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 8, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(0, 6))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 6, 6),
                LevelQuest(SpecialType.OpenBox, null, 4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 1, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 8, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 7, null),
                LevelQuest(SpecialType.None, Color.Cyan, 11, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 8, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 2, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Cyan, 15, null),
                LevelQuest(SpecialType.OpenBox, null, 4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Red, 11, null),
                LevelQuest(SpecialType.None, null, 8, 9)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 9, null),
                LevelQuest(SpecialType.None, Color.Cyan, 15, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 6, null),
                LevelQuest(SpecialType.None, Color.Red, 19, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Cyan, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Yellow, 4, null),
                LevelQuest(SpecialType.None, null, 5, 8)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Cyan, 13, null),
                LevelQuest(SpecialType.None, Color.Blue, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 5, null),
                LevelQuest(SpecialType.None, null, 6, 5)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5))),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 7, 6)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 6, null),
                LevelQuest(SpecialType.OpenBox, null, 9, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 3, null),
                LevelQuest(SpecialType.None, Color.Blue, 14, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 9, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Cyan, 15, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 4, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 1, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 1, 5)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 5, null),
                LevelQuest(SpecialType.None, Color.Cyan, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.OpenBox, null, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 2, 7)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 5, null),
                LevelQuest(SpecialType.None, null, 1, 9)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Blue, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 6, null),
                LevelQuest(SpecialType.None, null, 7, 6)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 10, null),
                LevelQuest(SpecialType.None, Color.Red, 7, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Red, 13, null),
                LevelQuest(SpecialType.None, Color.Green, 4, null)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 8, null),
                LevelQuest(SpecialType.None, Color.Blue, 10, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Cyan, 14, null),
                LevelQuest(SpecialType.OpenBox, null, 2, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 1, 7),
                LevelQuest(SpecialType.OpenBox, null, 2, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, Color.Yellow, 15, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 1)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 5)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(4, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 4, 9),
                LevelQuest(SpecialType.None, Color.Yellow, 4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 0)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 2)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, null, 2, 8),
                LevelQuest(SpecialType.None, Color.Cyan, 9, null)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(3, 5))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.OpenBox, null, 4, null),
                LevelQuest(SpecialType.None, null, 6, 9)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(4, 1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(3, 6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(5, 3)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(2, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(SpecialType.None, null, 3, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 6)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(5, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(0, 3))
            ),
        ),
    )
}
