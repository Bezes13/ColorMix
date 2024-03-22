package com.games.colormix.game

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.games.colormix.FieldSize
import com.games.colormix.MainViewEvent
import com.games.colormix.VerticalPadding
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField

@Composable
fun AnimationGrid(
    gameField: List<List<ColorField?>>,
    animateAt: Animation?,
    eventListener: (MainViewEvent) -> Unit,
) {
    val progress by animateFloatAsState(
        animationSpec = TweenSpec(500),
        targetValue = if(animateAt != null) 1f else 0f,
        label = "offset",
        finishedListener = {
            eventListener(MainViewEvent.SetAnimateAt(null))}
    )
    Box {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            for (i in gameField.indices) {
                Column(verticalArrangement = Arrangement.spacedBy(VerticalPadding)) {
                    for (j in gameField[i].indices) {
                        Box(
                            modifier = Modifier.size(FieldSize),
                            contentAlignment = Alignment.Center
                        ) {
                            if (Pair(i, j) == animateAt?.pos) {
                                Explosion(progress = progress, animateAt.color)
                            }
                        }

                    }
                }
            }
        }
    }
}