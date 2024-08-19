package com.games.colormix.start

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.unit.dp
import com.games.colormix.game.BlockExplosion


@Composable
fun Background(
    backGround: List<List<Color>>,
    animateAt: List<Pair<Int, Int>>,
    eventListener: (StartViewEvent) -> Unit
) {
    Column(
        Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        backGround.forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                row.forEach { block ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        modifier = Modifier.size(45.dp),
                    ) {
                        val largeRadialGradient = object : ShaderBrush() {
                            override fun createShader(size: Size): Shader {
                                return RadialGradientShader(
                                    colors = listOf(block, manipulateColor(color = block, 0.5f)),
                                    center = size.center,
                                    radius = size.height,
                                    colorStops = listOf(0f, 0.95f)
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(largeRadialGradient)
                        )
                    }
                }
            }
        }
    }
    Column(
        Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        backGround.forEachIndexed { rIndex, row ->
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                row.forEachIndexed { cIndex, block ->
                    Box(
                        modifier = Modifier.size(45.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        val animation = animateAt.firstOrNull { it == Pair(rIndex, cIndex) }
                        val progress by animateFloatAsState(
                            animationSpec = TweenSpec(1000),
                            targetValue = if (animation != null) 1f else 0f,
                            label = "progress",
                            finishedListener = {
                                eventListener(StartViewEvent.RemoveAnimationAt)
                            }
                        )
                        if (animation != null) {
                            BlockExplosion(progress = progress, block)
                        }
                    }
                }
            }
        }
    }
}