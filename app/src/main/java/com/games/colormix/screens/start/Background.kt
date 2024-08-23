package com.games.colormix.screens.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.games.colormix.constants.Padding
import com.games.colormix.data.ColorField
import com.games.colormix.screens.main.components.Animation.LazyAnimatedColumn
import com.games.colormix.utils.manipulateColor


@Composable
fun Background(
    fieldSize: Dp,
    backGround: List<List<ColorField>>,
) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Padding.M),
            modifier = Modifier.fillMaxHeight()
        ) {
            backGround.forEachIndexed { _, column ->
                LazyAnimatedColumn(
                    items = column,
                    keyProvider = { item -> item.toString() },
                    lazyModifier = { Modifier.animateItem() },
                ) { _, item ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        modifier = Modifier.size(fieldSize).padding(bottom = Padding.M),
                    ) {
                        val largeRadialGradient = object : ShaderBrush() {
                            override fun createShader(size: Size): Shader {
                                return RadialGradientShader(
                                    colors = listOf(item.color?: Color.Black, manipulateColor(color = item.color?: Color.Black, 0.5f)),
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