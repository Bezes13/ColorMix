package com.games.colormix.tutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.games.colormix.R
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialType
import com.games.colormix.game.QuestInfo

@Composable
fun QuestTutorial(dismiss: () -> Unit) {
    Dialog(onDismissRequest = dismiss) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(5.dp, MaterialTheme.colorScheme.secondary)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Tutorial : Quest",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                Divider(color = MaterialTheme.colorScheme.secondary)
                Column (Modifier.fillMaxHeight(0.9f)){
                    QuestTutorialItem(
                        LevelQuest(SpecialType.None, Color.Green, 6),
                        "Destroy Color Blocks",
                        "This means destroy 6 green Blocks"
                    )
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    QuestTutorialItem(
                        LevelQuest(SpecialType.OpenBox, null, 3),
                        "Destroy Boxes",
                        "Destroy Color Blocks next to Boxes to open/destroy them"
                    )
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    QuestTutorialItem(
                        LevelQuest(SpecialType.None, null, 4, 5),
                        "Destroy Multiblocks",
                        "Destroy multiple Color Blocks at the same time. \nThis 4 times 5 at the same time of any color."
                    )
                }
                Button(
                    onClick = dismiss,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.tertiary,
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    border = BorderStroke(3.dp, MaterialTheme.colorScheme.tertiary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.okay))
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.QuestTutorialItem(quest: LevelQuest, title: String, explanation: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                Text(text = title, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = explanation)
            }
        }
        QuestInfo(LevelInfo(listOf(quest)))

    }
}

@Preview
@Composable
fun QuestTutorialPreview() {
    QuestTutorial {

    }
}