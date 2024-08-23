package com.games.colormix.tutorial.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import com.games.colormix.constants.Padding
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.main.components.TutorialQuestInfo
import com.games.colormix.utils.MyText

@Composable
fun QuestTutorialItem(quest: LevelQuest, title: String, explanation: String, fieldSize: Dp) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = Padding.L),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(verticalArrangement = Arrangement.Center) {
            item {
                MyText(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize
                )
                Spacer(modifier = Modifier.size(Padding.L))
                MyText(text = explanation)
            }
        }
        TutorialQuestInfo(LevelInfo(listOf(quest)), fieldSize)
    }
}

