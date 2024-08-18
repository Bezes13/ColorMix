package com.games.colormix.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialType
import com.games.colormix.utils.MyText

@Composable
fun RowScope.QuestInfo(currentLevel: LevelInfo, fieldObjectSize: Dp) {
    val infoTextSize = with(LocalDensity.current) { fieldObjectSize.toSp() }

    LevelInfoCardRow {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                currentLevel.quests.forEach { quest ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        MyText(text = quest.amount.toString(), fontSize = infoTextSize)
                        Box {
                            if (quest.multiBlock != null) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(text = quest.multiBlock.toString() + "#", fontSize = infoTextSize)
                                    QuestObject(quest = quest, fieldObjectSize)
                                    QuestObject(quest = quest, fieldObjectSize)
                                    QuestObject(quest = quest, fieldObjectSize)
                                }
                            } else {
                                Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                                    QuestObject(quest = quest, fieldObjectSize)
                                    if (quest.specialType == SpecialType.None) {
                                        QuestObject(quest = quest, fieldObjectSize)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun QuestInfoPreview() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(80.dp)
    ) {
        QuestInfo(currentLevel = LevelInfo(listOf(LevelQuest(color = Color.Green, amount = 8))), 20.dp)
    }
}

@Composable
@Preview
fun QuestInfoPreview2() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(80.dp)
    ) {
        QuestInfo(currentLevel = LevelInfo(listOf(LevelQuest(amount = 8, multiBlock = 5))), 30.dp)
    }
}
