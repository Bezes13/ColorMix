package com.games.colormix.game

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.games.colormix.toPx
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ExplosionAnimation(progress: Float) {
    val particles = (0 until 30).map {
        val angle = Math.random() * 2 * Math.PI
        val speed =  (progress*Math.random() * 30f).dp.toPx()
        val xSpeed = cos(angle) * speed
        val ySpeed = sin(angle) * speed
        mutableStateOf(
            Particle(
                x = 0f,
                y = 0f,
                xSpeed = xSpeed.toFloat(),
                ySpeed = ySpeed.toFloat(),
                color = Color(255, (Math.random() * 255).toInt(), 0),
                size = (Math.random() * 30).dp
            )
        )
    }

    Canvas(
        modifier = Modifier
    ) {
        drawIntoCanvas {
            particles.forEach { particle ->
                particle.component1().update()
                it.drawCircle(
                    radius = particle.value.size.toPx(),
                    center = Offset(particle.value.x, particle.value.y),
                    paint = Paint().apply { color = particle.value.color }
                )
            }
        }
    }
}

data class Particle(
    var x: Float,
    var y: Float,
    var xSpeed: Float,
    var ySpeed: Float,
    val color: Color,
    val size: Dp
) {
    fun update() {
        x += xSpeed
        y += ySpeed
    }
}

@Preview
@Composable
fun PreviewExplosionAnimation() {
    ExplosionAnimation(1f)
}