package com.games.colormix.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.games.colormix.data.SpecialType

@Composable
fun RowScope.QuestInfo(currentLevel: LevelInfo) {
    LevelInfoCard {
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
                        Text(text = quest.amount.toString(), fontSize = 30.sp)
                        Box {
                            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                                QuestObject(quest = quest)
                                if (quest.specialType == SpecialType.None) {
                                    QuestObject(quest = quest)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}