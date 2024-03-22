package com.games.colormix.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.LevelInfoCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .weight(1f)
            .fillMaxSize()
            .padding(horizontal = 0.dp),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.secondary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        content()
    }
}

@Composable
fun LevelInfoCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize(),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.secondary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        content()
    }
}