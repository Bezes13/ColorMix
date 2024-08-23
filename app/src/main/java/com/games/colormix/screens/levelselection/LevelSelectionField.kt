package com.games.colormix.screens.levelselection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.games.colormix.constants.BorderWidth
import com.games.colormix.constants.ItemRowCount
import com.games.colormix.game.LevelLists
import com.games.colormix.navigation.Screen
import com.games.colormix.utils.MyText

@Composable
fun LevelSelectionField(
    index: Pair<Int, Int>,
    currentLevel: Int,
    size: Dp,
    navigate: (String) -> Unit,
    getPoints: (Int) -> Int
) {
    val level = (index.first * ItemRowCount + index.second)
    val textSizeLevel = with(LocalDensity.current) { (size/2).toSp() }
    val textSizePoints = with(LocalDensity.current) { (size/4).toSp() }

    if (level <= LevelLists.levelList.size) {
        val playable = level < currentLevel + 1
        val modifierClickable = Modifier.clickable { navigate(Screen.Main.name + "/${level}") }

        val modifier = if (playable) modifierClickable else Modifier
        val alpha = if (playable) 1f else 0.5f

        Card(
            modifier = modifier.size(size),
            border = BorderStroke(
                BorderWidth,
                MaterialTheme.colorScheme.secondary.copy(alpha = alpha)
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(
                    alpha = alpha
                ),
                contentColor = MaterialTheme.colorScheme.secondary.copy(
                    alpha = alpha
                )
            )
        ) {
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    MyText(
                        text = level.toString(),
                        fontSize = textSizeLevel,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = BorderWidth,
                        color = MaterialTheme.colorScheme.secondary.copy(
                            alpha = alpha
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    MyText(
                        text = getPoints(level).toString(),
                        fontSize = textSizePoints,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}