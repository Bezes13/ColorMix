package com.games.colormix.screens.main.components.Animation

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.games.colormix.constants.BlockAnimationDuration
import com.games.colormix.constants.ExplosionDuration
import com.games.colormix.constants.Padding
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.screens.main.MainViewEvent

@Composable
fun AnimationGrid(
    gameField: List<List<ColorField?>>,
    animateAt: List<Animation>,
    size: Dp,
    eventListener: (MainViewEvent) -> Unit,
) {
    Box {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Padding.M),
        ) {
            for (i in gameField.indices) {
                Column(verticalArrangement = Arrangement.spacedBy(Padding.M)) {
                    for (j in gameField[i].indices) {
                        AnimationAt(size, animateAt, Pair(i, j), eventListener)
                    }
                }
            }
        }
    }
}

@Composable
private fun AnimationAt(
    size: Dp,
    animateAt: List<Animation>,
    pos: Pair<Int, Int>,
    eventListener: (MainViewEvent) -> Unit
) {
    Box(
        modifier = Modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        val animation = animateAt.firstOrNull { it.pos == pos }
        val progress by animateFloatAsState(
            animationSpec = TweenSpec(if (animation?.color == Color.Black) ExplosionDuration else BlockAnimationDuration),
            targetValue = if (animation != null) 1f else 0f,
            label = "progress",
            finishedListener = {
                eventListener(MainViewEvent.RemoveAnimationAt(pos))
            }
        )
        if (animation != null) {
            if (animation.color == Color.Black) {
                BombAnimation(progress)
            } else {
                BlockExplosion(progress = progress, animation.color)
            }
        }
    }
}