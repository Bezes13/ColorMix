package com.games.colormix.screens.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.games.colormix.constants.BorderWidth

@Composable
fun BorderedBox(
    modifier: Modifier = Modifier,
    borderStroke: BorderStroke = BorderStroke(
        BorderWidth,
        MaterialTheme.colorScheme.primary.copy(0.3f)
    ),
    shape: Shape = CardDefaults.shape,
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