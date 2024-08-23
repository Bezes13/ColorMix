package com.games.colormix.tutorial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.window.Dialog
import com.games.colormix.R
import com.games.colormix.constants.BorderWidth
import com.games.colormix.constants.BorderWidthLarge
import com.games.colormix.constants.Padding
import com.games.colormix.hackClassLoader
import com.games.colormix.tutorial.component.PowerUpTutorialItem
import com.games.colormix.utils.MyText

@Composable
fun PowerUpTutorial(dismiss: () -> Unit) {
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
                    text = "Tutorial : PowerUps",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize
                )
                Divider(color = MaterialTheme.colorScheme.secondary)
                Column(Modifier.fillMaxHeight(0.9f), verticalArrangement = Arrangement.SpaceEvenly) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        PowerUpTutorialItem(
                            stringResource(R.string.bomb),
                            stringResource(R.string.tuturial_bomb) +
                                    stringResource(R.string.tutorial_bomb2),
                            R.drawable.bomb
                        )
                    }
                    Divider(color = MaterialTheme.colorScheme.secondary)

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        PowerUpTutorialItem(
                            stringResource(R.string.rubik_s_cube),
                            stringResource(R.string.tutorial_rubik) +
                                    stringResource(R.string.tutorial_rubik1) +
                                    stringResource(R.string.tutorial_rubik2),
                            R.drawable.rubik,
                            0.3f
                        )
                    }

                    Divider(color = MaterialTheme.colorScheme.secondary)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            MyText(
                                text = stringResource(R.string.rock),
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                                textDecoration = TextDecoration.Underline
                            )
                            Spacer(modifier = Modifier.size(Padding.L))
                            MyText(text = stringResource(R.string.tutorial_rock))
                        }
                        Image(
                            painter = painterResource(id = R.drawable.rock),
                            contentDescription = "Rock",
                        )
                    }
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
fun PowerUpTutorialPreview() {
    hackClassLoader()
    PowerUpTutorial {

    }
}