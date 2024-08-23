package com.games.colormix.screens.main.components.Animation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.games.colormix.data.Particle
import com.games.colormix.utils.manipulateColor
import com.games.colormix.utils.randomInRange
import com.games.colormix.utils.toPx
import kotlin.math.roundToInt

@Composable
fun BlockExplosion(progress: Float, color: Color) {
    val sizeDp = 200.dp
    val sizePx = sizeDp.toPx()
    val particles = remember {
        List(10) {
            Particle(
                color = color,
                maxHorizontalDisplacement = sizePx * randomInRange(-0.9f, 0.9f),
                maxVerticalDisplacement = sizePx * randomInRange(0.2f, 0.38f),
            )
        }
    }
    particles.forEach { it.updateProgress(progress) }
    particles.forEach { particle ->
        Card(
            colors = CardDefaults.cardColors(containerColor = particle.color),
            modifier = Modifier
                .size(20.dp)
                .offset {
                    IntOffset(
                        (particle.currentXPosition).roundToInt(),
                        particle.currentYPosition.roundToInt()
                    )
                }
                .alpha(particle.alpha),
            shape = RoundedCornerShape(5.dp)
        ) {
            val largeRadialGradient = object : ShaderBrush() {
                override fun createShader(size: Size): Shader {
                    return RadialGradientShader(
                        colors = listOf( color, manipulateColor(color =  color,0.5f)),
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