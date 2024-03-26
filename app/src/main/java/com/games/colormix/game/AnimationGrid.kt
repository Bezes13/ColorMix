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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.games.colormix.main.FieldSize
import com.games.colormix.main.MainViewEvent
import com.games.colormix.main.VerticalPadding
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField

@Composable
fun AnimationGrid(
    gameField: List<List<ColorField?>>,
    animateAt: List<Animation>,
    eventListener: (MainViewEvent) -> Unit,
) {
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
                            val animation = animateAt.firstOrNull { it.pos == Pair(i,j) }
                            val progress by animateFloatAsState(
                            animationSpec = TweenSpec( if (animation?.color == Color.Black) 200 else 500),
                            targetValue = if (animation != null) 1f else 0f,
                            label = "progress",
                            finishedListener = {
                                eventListener(MainViewEvent.RemoveAnimationAt(Pair(i,j)))
                            }
                        )
                            if (animation != null) {
                                if (animation.color == Color.Black) {
                                    ExplosionAnimation(progress)
                                } else {
                                    Explosion(progress = progress, animation.color)
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}