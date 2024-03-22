package com.games.colormix.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun BorderedBox(
    modifier: Modifier = Modifier,
    borderStroke: BorderStroke = BorderStroke(
        3.dp,
        MaterialTheme.colorScheme.primary.copy(0.3f)
    ),
    shape: Shape = RoundedCornerShape(8.dp),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .padding(top = borderStroke.width)
            .then(Modifier.border(borderStroke, shape)),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}