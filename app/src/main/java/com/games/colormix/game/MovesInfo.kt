package com.games.colormix.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.games.colormix.data.LevelInfo
import com.games.colormix.utils.MyText

@Composable
fun RowScope.MovesInfo(currentLevel: LevelInfo, textSize: TextUnit) {
    LevelInfoCardRow {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            MyText(text = "Moves:", fontSize = textSize)
            MyText(text = currentLevel.moves.toString(), fontSize = textSize)
        }
    }
}