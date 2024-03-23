package com.games.colormix.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.games.colormix.FieldSize
import com.games.colormix.R
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType

object LevelData {

    val LEVELS = listOf<LevelInfo>(
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
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.OpenBox, Pair(3,3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,5))),
            moves = 5
        ),
        // Level 11
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,0)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,1)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,2)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,3)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,4)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,5)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,6)),
                SpecialBlockPlacement(SpecialType.OpenBox, Pair(0,7))),
            moves = 15
        ),
        // Level 12
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Box, Pair(0,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(0,7))),
            moves = 20
        ),
        // Level 13
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 8)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Box, Pair(6,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,1)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,2)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,4)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,5)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,6)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,7))),
            moves = 20
        ),
        // Level 14
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 7)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Box, Pair(0,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(2,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(4,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(5,0)),
                SpecialBlockPlacement(SpecialType.Box, Pair(6,0))),
            moves = 20
        ),
        // Level 15
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 1)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.Rock, Pair(3,3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3,4))),
            moves = 5
        ),
        // Level 16
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 2)),
            specialBlocks = listOf(
                SpecialBlockPlacement(SpecialType.Rock, Pair(1, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(1, 4)),
                SpecialBlockPlacement(SpecialType.Rock, Pair(3, 3)),
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4))),
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
                SpecialBlockPlacement(SpecialType.Box, Pair(3, 4))),
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
                SpecialBlockPlacement(SpecialType.Box, Pair(4, 4))),
            moves = 12
        ),
    )
}

@Composable
fun QuestObject(quest: LevelQuest){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = quest.color ?: Color.Transparent
        ),
        modifier = Modifier.size(FieldSize /2),
        shape = RoundedCornerShape(2.dp),
        border = BorderStroke(1.dp, Color.Black)
    )
    {
        if (quest.specialType != SpecialType.None) {
            Image(
                painter = when (quest.specialType) {
                    SpecialType.Rock -> painterResource(id = R.drawable.rock)
                    SpecialType.Box -> painterResource(id = R.drawable.box)
                    SpecialType.OpenBox -> painterResource(id = R.drawable.boxopen)
                    else -> painterResource(id = R.drawable.ic_launcher_foreground)
                },
                contentDescription = "SpecialType",
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

data class LevelInfo(
    val quests: List<LevelQuest> = listOf(),
    val specialBlocks: List<SpecialBlockPlacement> = listOf(),
    val moves: Int,
    val level: Int = 100
)