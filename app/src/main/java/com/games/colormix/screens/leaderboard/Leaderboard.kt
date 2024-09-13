package com.games.colormix.screens.leaderboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.games.colormix.model.BoardScore
import com.games.colormix.utils.MyText
import com.games.colormix.utils.withThousandSeparators

@Composable
fun LeaderBoard(leaderboard: List<BoardScore>, scoreText: String) {
    Card (
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.9f),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f))){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LeaderBoardText("",0.1f)
            LeaderBoardText("Name", 0.8f)
            LeaderBoardText(scoreText, 1f)
        }
        Divider(color = Color.White)
        leaderboard.forEachIndexed { index, score ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LeaderBoardText((index+1).toString() +".",0.1f)
                LeaderBoardText(text = score.name, 0.8f)
                LeaderBoardText(text = score.points.withThousandSeparators(), 1f)
            }
        }
    }
}

@Composable
private fun RowScope.LeaderBoardText(text: String, weight: Float) {
    MyText(
        text = text,
        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
        modifier = Modifier.weight(weight),
        textAlign = TextAlign.Center
    )
}