package com.games.colormix

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
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType

object LevelData {

    val LEVELS = listOf<LevelInfo>(
        // Level 1
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Green, 6)),
            moves = 5
        ),
        // Level 2
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Red, 8)),
            moves = 5
        ),
        // Level 3
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Yellow, 10)),
            moves = 5
        ),
        // Level 4
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Cyan, 12)),
            moves = 5
        ),
        // Level 5
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.None, Color.Blue, 15)),
            moves = 5
        ),
        // Level 6
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Green, 15),
                LevelQuest(SpecialType.None, Color.Red, 15)
            ),
            moves = 10
        ),
        // Level 7
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 15),
                LevelQuest(SpecialType.None, Color.Cyan, 15)
            ),
            moves = 10
        ),
        // Level 8
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Yellow, 15),
                LevelQuest(SpecialType.None, Color.Green, 15)
            ),
            moves = 10
        ),
        // Level 9
        LevelInfo(
            quests = listOf(
                LevelQuest(SpecialType.None, Color.Blue, 20),
                LevelQuest(SpecialType.None, Color.Cyan, 20)
            ),
            moves = 10
        ),
        // Level 10
        LevelInfo(
            quests = listOf(element = LevelQuest(SpecialType.OpenBox, null, 1)),
            specialBlocks = listOf(SpecialBlockPlacement(SpecialType.OpenBox, Pair(3,3))),
            moves = 5
        )

    )
}

@Composable
fun QuestObject(quest: LevelQuest){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = quest.color ?: Color.Transparent
        ),
        modifier = Modifier.size(FieldSize/2),
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
    val moves: Int
)