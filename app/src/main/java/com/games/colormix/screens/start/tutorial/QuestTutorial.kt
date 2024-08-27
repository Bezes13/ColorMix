package com.games.colormix.screens.start.tutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.games.colormix.R
import com.games.colormix.constants.BorderWidth
import com.games.colormix.constants.BorderWidthLarge
import com.games.colormix.constants.Padding
import com.games.colormix.data.BlockType
import com.games.colormix.data.LevelQuest
import com.games.colormix.screens.start.tutorial.component.QuestTutorialItem
import com.games.colormix.utils.MyText

@Composable
fun QuestTutorial(fieldSize: Dp, dismiss: () -> Unit) {
    Dialog(onDismissRequest = dismiss) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(BorderWidthLarge, MaterialTheme.colorScheme.secondary)
        ) {
            Column(modifier = Modifier.padding(Padding.L)) {
                MyText(
                    text = "Tutorial : Quest",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize
                )
                Divider(color = MaterialTheme.colorScheme.secondary)
                Column(
                    Modifier.fillMaxHeight(0.9f),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    QuestTutorialItem(
                        LevelQuest(BlockType.Earth, 6),
                        stringResource(R.string.destroy_color_blocks),
                        stringResource(R.string.tutorial_colored),
                        fieldSize
                    )
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    QuestTutorialItem(
                        LevelQuest(BlockType.FallingBox, 3),
                        stringResource(R.string.destroy_boxes),
                        stringResource(R.string.tutorial_box),
                        fieldSize
                    )
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    QuestTutorialItem(
                        LevelQuest(BlockType.Empty, 4, 5),
                        stringResource(R.string.destroy_multiblocks),
                        stringResource(R.string.tutorial_multi),
                        fieldSize
                    )
                }
                Button(
                    onClick = dismiss,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.tertiary,
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    border = BorderStroke(BorderWidth, MaterialTheme.colorScheme.tertiary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.okay))
                }
            }
        }
    }
}

@Preview
@Composable
fun QuestTutorialPreview() {
    QuestTutorial(30.dp) {

    }
}