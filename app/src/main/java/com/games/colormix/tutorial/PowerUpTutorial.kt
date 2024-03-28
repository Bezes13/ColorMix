package com.games.colormix.tutorial

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.games.colormix.R
import com.games.colormix.game.DraggableItem

@Composable
fun PowerUpTutorial(dismiss: () -> Unit) {
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
                    text = "Tutorial : PowerUps",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                Divider(color = MaterialTheme.colorScheme.secondary)
                Column (Modifier.fillMaxHeight(0.9f)){
                    PowerUpTutorialItem(
                        "Bomb",
                        "Drag this on Single Blocks to destroy it.\n" +
                                "You gain Bombs by destroying 6 or more Color Blocks at the same time.",
                        R.drawable.bomb
                    )
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    PowerUpTutorialItem(
                        "Rubik's Cube",
                        "Drag this on a Color Block to destroy all Blocks with the same Color.\n\n " +
                                "You gain Cubes after every 50th destroyed Block.\n" +
                                "The Progressbar shows you when to get a new Cube.",
                        R.drawable.rubik,
                        0.3f
                    )
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Rock", fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "Obstacle which doesn't move. It can only be destroyed by a bomb.")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.rock),
                        contentDescription = "Rock",
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
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
private fun ColumnScope.PowerUpTutorialItem(title: String, explanation: String, @DrawableRes res: Int, progress: Float? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = explanation)
        }
        Box (modifier = Modifier.height(70.dp)){
            DraggableItem(title, 3, res, progress )
        }


    }
}

@Preview
@Composable
fun PowerUpTutorialPreview() {
    PowerUpTutorial {

    }
}