package com.games.colormix.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.games.colormix.data.Particle
import com.games.colormix.randomInRange
import com.games.colormix.toPx
import kotlin.math.roundToInt

@Composable
fun Explosion(progress: Float, color: Color) {
    val sizeDp = 200.dp
    val sizePx = sizeDp.toPx()
    val particles = remember {
        List(5) {
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
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(0.dp)
        ) {}
    }
}