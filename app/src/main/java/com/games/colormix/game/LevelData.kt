package com.games.colormix.game

import com.games.colormix.data.BlockType
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement

object LevelData {
    val LEVEL_GROUP1 = listOf(
        // Level 1
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.Earth, 6))
        ),
        // Level 2
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.Mercury, 8)),

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
            quests = listOf(element = LevelQuest(BlockType.Moon, 10)),
        ),
        // Level 4
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.Saturn, 12)),

            ),
        // Level 5
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.Uranus, 15)),

            ),
        // Level 6
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Earth, 15),
                LevelQuest(BlockType.Mercury, 15)
            ),

            ),
        // Level 7
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Uranus, 15),
                LevelQuest(BlockType.Saturn, 15)
            ),

            ),
        // Level 8
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Moon, 15),
                LevelQuest(BlockType.Earth, 15)
            ),
        ),
        // Level 9
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Uranus, 20),
                LevelQuest(BlockType.Saturn, 20)
            ),
        ),
        // Level 10
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox, 2)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 5))
            ),
        ),
        // Level 11
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 7))
            ),
        ),
        // Level 12
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 7))
            ),
        ),
        // Level 14
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  7)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(6, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(7, 0))
            ),
        ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  1)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 4))
            ),
        ),

        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(amount = 1, multiBlock = 6)),
            specialBlocks = listOf(),
        ),
        // Level 16
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  2)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 4))
            ),

            ),
        // Level 17
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  3)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 4))
            ),

            ),
        // Level 18
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  4)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(6, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(6, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 4))
            ),

            ),
        // Level 18
        LevelInfo(
            quests = listOf(element = LevelQuest(BlockType.FallingBox,  3)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(6, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  4, null),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  14, null),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,8, 6),
                LevelQuest(BlockType.Mercury, 16, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Earth, 17, null),
                LevelQuest(BlockType.Uranus, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  9, null),
                LevelQuest(BlockType.Empty,  7, 7)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  1, 5),
                LevelQuest(BlockType.FallingBox,  2, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  3, null),
                LevelQuest(BlockType.Empty,  9, 7)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  11, null),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  5, null),
                LevelQuest(BlockType.Empty,  1, 5),
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  4, null),
                LevelQuest(BlockType.Saturn, 15, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 6)))
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Mercury, 9, null),
                LevelQuest(BlockType.Empty,  4, 8)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0))
            )
        ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Earth, 4, null),
                LevelQuest(BlockType.FallingBox,  3, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Earth, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  8, 9),
                LevelQuest(BlockType.FallingBox,  6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Mercury, 12, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 9, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  9, 7),
                LevelQuest(BlockType.Mercury, 7, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  7, null),
                LevelQuest(BlockType.Uranus, 15, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Mercury, 19, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  5, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  1, 8),
                LevelQuest(BlockType.FallingBox,  4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  1, null),
                LevelQuest(BlockType.Earth, 7, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  2, 7),
                LevelQuest(BlockType.Earth, 6, null)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3, 2))),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  5, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Earth, 4, null),
                LevelQuest(BlockType.FallingBox,  9, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  8, null),
                LevelQuest(BlockType.Empty,  7, 9)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  2, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Moon, 11, null),
                LevelQuest(BlockType.Empty,  4, 5)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 6)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0, 6))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  6, 6),
                LevelQuest(BlockType.FallingBox,  4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  8, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  7, null),
                LevelQuest(BlockType.Saturn, 11, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  8, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  2, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Saturn, 15, null),
                LevelQuest(BlockType.FallingBox,  4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Mercury, 11, null),
                LevelQuest(BlockType.Empty,  8, 9)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  9, null),
                LevelQuest(BlockType.Saturn, 15, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  6, null),
                LevelQuest(BlockType.Mercury, 19, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Saturn, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Moon, 4, null),
                LevelQuest(BlockType.Empty,  5, 8)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Saturn, 13, null),
                LevelQuest(BlockType.Uranus, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Uranus, 5, null),
                LevelQuest(BlockType.Empty,  6, 5)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5))),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  7, 6)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Earth, 6, null),
                LevelQuest(BlockType.FallingBox,  9, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  3, null),
                LevelQuest(BlockType.Uranus, 14, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  9, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Saturn, 15, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  4, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  1, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 5)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  5, null),
                LevelQuest(BlockType.Saturn, 6, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Box, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.Box, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Box, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.Box, Pair(3, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Box, Pair(0, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  2, 7)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Uranus, 5, null),
                LevelQuest(BlockType.Empty,  1, 9)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Uranus, 7, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  6, null),
                LevelQuest(BlockType.Empty,  7, 6)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 6, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Uranus, 10, null),
                LevelQuest(BlockType.Mercury, 7, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Mercury, 13, null),
                LevelQuest(BlockType.Earth, 4, null)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  8, null),
                LevelQuest(BlockType.Uranus, 10, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 1))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Saturn, 14, null),
                LevelQuest(BlockType.FallingBox,  2, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(0, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 0))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  1, 7),
                LevelQuest(BlockType.FallingBox,  2, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(3, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(1, 6))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 15, null)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 1)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 5)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(4, 2))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  4, 9),
                LevelQuest(BlockType.Moon, 4, null)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 0)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 2)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 5))
            ),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.Empty,  2, 8),
                LevelQuest(BlockType.Saturn, 9, null)
            ),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3, 5))),

            ),
        LevelInfo(
            quests = listOf(
                LevelQuest(BlockType.FallingBox,  4, null),
                LevelQuest(BlockType.Empty,  6, 9)
            ),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.FallingBox, Pair(4, 1)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(3, 6)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(1, 4)),
                SpecialBlockPlacement(BlockType.FallingBox, Pair(5, 3)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(2, 4))
            ),

            ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  3, 8)),
            specialBlocks = listOf(
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 6)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(5, 4)),
                SpecialBlockPlacement(BlockType.Blocker, Pair(0, 3))
            ),
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  5, null), LevelQuest(BlockType.Empty,  9, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(3,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  9, null), LevelQuest(BlockType.Earth, 17, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(5,5)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(0,0)), SpecialBlockPlacement(BlockType.Box, Pair(3,1)), SpecialBlockPlacement(BlockType.Box, Pair(4,1)), SpecialBlockPlacement(BlockType.Box, Pair(2,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,2)), SpecialBlockPlacement(BlockType.Box, Pair(5,1)), SpecialBlockPlacement(BlockType.Box, Pair(0,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  3, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  5, null), LevelQuest(BlockType.Moon, 13, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(4,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  4, 5), LevelQuest(BlockType.Saturn, 13, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  7, null), LevelQuest(BlockType.Uranus, 15, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(2,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  6, null), LevelQuest(BlockType.Moon, 13, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(1,0)), SpecialBlockPlacement(BlockType.Box, Pair(1,3)), SpecialBlockPlacement(BlockType.Box, Pair(3,4)), SpecialBlockPlacement(BlockType.Box, Pair(2,4)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  7, 5), LevelQuest(BlockType.Uranus, 7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  3, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 8), LevelQuest(BlockType.Mercury, 12, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  9, 8), LevelQuest(BlockType.FallingBox,  6, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(0,5)), SpecialBlockPlacement(BlockType.Box, Pair(2,2)), SpecialBlockPlacement(BlockType.Box, Pair(2,1)), SpecialBlockPlacement(BlockType.Box, Pair(3,3)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(0,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Uranus, 9, null), LevelQuest(BlockType.Moon, 18, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  3, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  9, null), LevelQuest(BlockType.Empty,  9, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(5,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 6), LevelQuest(BlockType.FallingBox,  1, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 8), LevelQuest(BlockType.Mercury, 16, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  1, null), LevelQuest(BlockType.Empty,  7, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(5,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  3, 9), LevelQuest(BlockType.Earth, 7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 7), LevelQuest(BlockType.FallingBox,  7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(0,2)), SpecialBlockPlacement(BlockType.Box, Pair(0,3)), SpecialBlockPlacement(BlockType.Box, Pair(4,6)), SpecialBlockPlacement(BlockType.Box, Pair(1,1)), SpecialBlockPlacement(BlockType.Box, Pair(5,4)), SpecialBlockPlacement(BlockType.Box, Pair(3,4)), SpecialBlockPlacement(BlockType.Box, Pair(4,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  2, 9), LevelQuest(BlockType.FallingBox,  3, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(0,4)), SpecialBlockPlacement(BlockType.Box, Pair(3,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  9, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  2, 7), LevelQuest(BlockType.Mercury, 15, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Saturn, 16, null), LevelQuest(BlockType.FallingBox,  9, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(2,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 7, null), LevelQuest(BlockType.Saturn, 16, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 9), LevelQuest(BlockType.FallingBox,  6, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(1,1)), SpecialBlockPlacement(BlockType.Box, Pair(0,4)), SpecialBlockPlacement(BlockType.Box, Pair(1,2)), SpecialBlockPlacement(BlockType.Box, Pair(2,2)), SpecialBlockPlacement(BlockType.Box, Pair(4,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  7, 9), LevelQuest(BlockType.Mercury, 14, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  9, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  7, 7), LevelQuest(BlockType.FallingBox,  2, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(0,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  2, null), LevelQuest(BlockType.Empty,  7, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  7, 7), LevelQuest(BlockType.FallingBox,  5, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,3)), SpecialBlockPlacement(BlockType.Box, Pair(5,6)), SpecialBlockPlacement(BlockType.Box, Pair(5,1)), SpecialBlockPlacement(BlockType.Box, Pair(0,3)), SpecialBlockPlacement(BlockType.Box, Pair(2,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Earth, 7, null), LevelQuest(BlockType.Empty,  9, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  7, null), LevelQuest(BlockType.Empty,  7, 5)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(5,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  6, null), LevelQuest(BlockType.Empty,  6, 5)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(5,2)), SpecialBlockPlacement(BlockType.Box, Pair(3,2)), SpecialBlockPlacement(BlockType.Box, Pair(0,4)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(2,6)), SpecialBlockPlacement(BlockType.Box, Pair(1,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  9, 8), LevelQuest(BlockType.FallingBox,  8, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,0)), SpecialBlockPlacement(BlockType.Box, Pair(4,1)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(4,6)), SpecialBlockPlacement(BlockType.Box, Pair(5,4)), SpecialBlockPlacement(BlockType.Box, Pair(3,2)), SpecialBlockPlacement(BlockType.Box, Pair(4,2)), SpecialBlockPlacement(BlockType.Box, Pair(1,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  9, null), LevelQuest(BlockType.Empty,  8, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(5,3)), SpecialBlockPlacement(BlockType.Box, Pair(5,4)), SpecialBlockPlacement(BlockType.Box, Pair(0,5)), SpecialBlockPlacement(BlockType.Box, Pair(2,3)), SpecialBlockPlacement(BlockType.Box, Pair(1,2)), SpecialBlockPlacement(BlockType.Box, Pair(4,1)), SpecialBlockPlacement(BlockType.Box, Pair(0,0)), SpecialBlockPlacement(BlockType.Box, Pair(4,5)), SpecialBlockPlacement(BlockType.Box, Pair(0,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 6), LevelQuest(BlockType.FallingBox,  6, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,6)), SpecialBlockPlacement(BlockType.Box, Pair(2,4)), SpecialBlockPlacement(BlockType.Box, Pair(0,5)), SpecialBlockPlacement(BlockType.Box, Pair(4,4)), SpecialBlockPlacement(BlockType.Box, Pair(4,0)), SpecialBlockPlacement(BlockType.Box, Pair(4,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 12, null), LevelQuest(BlockType.Empty,  3, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  9, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 6), LevelQuest(BlockType.FallingBox,  7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,6)), SpecialBlockPlacement(BlockType.Box, Pair(3,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,4)), SpecialBlockPlacement(BlockType.Box, Pair(5,5)), SpecialBlockPlacement(BlockType.Box, Pair(4,1)), SpecialBlockPlacement(BlockType.Box, Pair(3,2)), SpecialBlockPlacement(BlockType.Box, Pair(0,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 9), LevelQuest(BlockType.FallingBox,  7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(0,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 5), LevelQuest(BlockType.Moon, 6, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Saturn, 12, null), LevelQuest(BlockType.FallingBox,  6, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(3,0)), SpecialBlockPlacement(BlockType.Box, Pair(2,5)), SpecialBlockPlacement(BlockType.Box, Pair(3,5)), SpecialBlockPlacement(BlockType.Box, Pair(3,3)), SpecialBlockPlacement(BlockType.Box, Pair(0,5)), SpecialBlockPlacement(BlockType.Box, Pair(2,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  2, 6), LevelQuest(BlockType.Uranus, 18, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 9), LevelQuest(BlockType.FallingBox,  1, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 8), LevelQuest(BlockType.Saturn, 13, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  4, 8), LevelQuest(BlockType.Uranus, 7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Earth, 4, null), LevelQuest(BlockType.Empty,  5, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(4,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 12, null), LevelQuest(BlockType.FallingBox,  9, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(1,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 9), LevelQuest(BlockType.Saturn, 17, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  5, null), LevelQuest(BlockType.Empty,  3, 5)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(0,6)), SpecialBlockPlacement(BlockType.Box, Pair(4,2)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(1,1)), SpecialBlockPlacement(BlockType.Box, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  7, 7), LevelQuest(BlockType.Mercury, 10, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  7, null), LevelQuest(BlockType.Mercury, 17, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,1)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 5), LevelQuest(BlockType.FallingBox,  3, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(4,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 8), LevelQuest(BlockType.Saturn, 15, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,3)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  8, null), LevelQuest(BlockType.Empty,  4, 6)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,0)), SpecialBlockPlacement(BlockType.Box, Pair(0,3)), SpecialBlockPlacement(BlockType.Box, Pair(4,4)), SpecialBlockPlacement(BlockType.Box, Pair(1,2)), SpecialBlockPlacement(BlockType.Box, Pair(5,6)), SpecialBlockPlacement(BlockType.Box, Pair(2,4)), SpecialBlockPlacement(BlockType.Box, Pair(0,0)), SpecialBlockPlacement(BlockType.Box, Pair(3,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Earth, 16, null), LevelQuest(BlockType.FallingBox,  6, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(5,1)), SpecialBlockPlacement(BlockType.Box, Pair(4,5)), SpecialBlockPlacement(BlockType.Box, Pair(1,0)), SpecialBlockPlacement(BlockType.Box, Pair(1,4)), SpecialBlockPlacement(BlockType.Box, Pair(4,2)), SpecialBlockPlacement(BlockType.Box, Pair(0,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 6)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  2, null), LevelQuest(BlockType.Empty,  6, 5)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,2)), SpecialBlockPlacement(BlockType.Box, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  3, null), LevelQuest(BlockType.Empty,  5, 6)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(3,5)), SpecialBlockPlacement(BlockType.Box, Pair(1,6)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Mercury, 14, null), LevelQuest(BlockType.FallingBox,  7, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(4,2)), SpecialBlockPlacement(BlockType.Box, Pair(3,6)), SpecialBlockPlacement(BlockType.Box, Pair(0,3)), SpecialBlockPlacement(BlockType.Box, Pair(4,0)), SpecialBlockPlacement(BlockType.Box, Pair(3,0)), SpecialBlockPlacement(BlockType.Box, Pair(3,1)), SpecialBlockPlacement(BlockType.Box, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  5, null), LevelQuest(BlockType.Empty,  9, 9)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(1,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  5, 7), LevelQuest(BlockType.Uranus, 4, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 7), LevelQuest(BlockType.FallingBox,  1, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(1,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  9, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(2,6)), SpecialBlockPlacement(BlockType.Box, Pair(1,0)), SpecialBlockPlacement(BlockType.Box, Pair(3,2)), SpecialBlockPlacement(BlockType.Box, Pair(1,6)), SpecialBlockPlacement(BlockType.Box, Pair(3,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,6)), SpecialBlockPlacement(BlockType.Box, Pair(2,4)), SpecialBlockPlacement(BlockType.Box, Pair(1,1)), SpecialBlockPlacement(BlockType.Box, Pair(5,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 5), LevelQuest(BlockType.FallingBox,  5, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(4,3)), SpecialBlockPlacement(BlockType.Box, Pair(4,0)), SpecialBlockPlacement(BlockType.Box, Pair(0,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,5)), SpecialBlockPlacement(BlockType.Box, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Uranus, 8, null), LevelQuest(BlockType.FallingBox,  8, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Box, Pair(4,0)), SpecialBlockPlacement(BlockType.Box, Pair(2,3)), SpecialBlockPlacement(BlockType.Box, Pair(3,3)), SpecialBlockPlacement(BlockType.Box, Pair(2,0)), SpecialBlockPlacement(BlockType.Box, Pair(5,0)), SpecialBlockPlacement(BlockType.Box, Pair(1,1)), SpecialBlockPlacement(BlockType.Box, Pair(0,0)), SpecialBlockPlacement(BlockType.Box, Pair(2,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,2)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  3, 7), LevelQuest(BlockType.Moon, 13, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(5,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Saturn, 16, null), LevelQuest(BlockType.Empty,  3, 6)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  4, 7), LevelQuest(BlockType.Mercury, 10, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 6), LevelQuest(BlockType.Uranus, 14, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(4,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  9, 5)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(2,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 5)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.FallingBox,  8, null), LevelQuest(BlockType.Moon, 11, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(4,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,5)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  1, 7), LevelQuest(BlockType.Moon, 18, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,6)), SpecialBlockPlacement(BlockType.Blocker, Pair(2,5)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(4,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,1)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 9), LevelQuest(BlockType.FallingBox,  5, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(4,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(5,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,2)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,2)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  6, 6), LevelQuest(BlockType.FallingBox,  8, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.FallingBox, Pair(4,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,6)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(2,0)), SpecialBlockPlacement(BlockType.FallingBox, Pair(1,4)), SpecialBlockPlacement(BlockType.FallingBox, Pair(4,3)), SpecialBlockPlacement(BlockType.FallingBox, Pair(3,5)), SpecialBlockPlacement(BlockType.FallingBox, Pair(0,4)), SpecialBlockPlacement(BlockType.Blocker, Pair(5,0)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  8, 8), LevelQuest(BlockType.Mercury, 11, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(0,4)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Empty,  4, 6)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(3,1)), SpecialBlockPlacement(BlockType.Blocker, Pair(3,6)))
        ),
        LevelInfo(
            quests = listOf(LevelQuest(BlockType.Moon, 13, null), LevelQuest(BlockType.Saturn, 15, null)),
            specialBlocks = listOf(SpecialBlockPlacement(BlockType.Blocker, Pair(1,0)), SpecialBlockPlacement(BlockType.Blocker, Pair(1,2)))
        ),
        )
}
