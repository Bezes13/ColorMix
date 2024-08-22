package com.games.colormix.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import com.games.colormix.data.ColorField
import com.games.colormix.game.LazyAnimatedColumn
import com.games.colormix.game.defaultEnterTransition
import com.games.colormix.game.defaultExitTransition
import com.games.colormix.main.VerticalPadding


@Composable
fun Background(
    backGround: List<List<ColorField>>,
) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            backGround.forEachIndexed { _, column ->
                LazyAnimatedColumn(
                    items = column,
                    keyProvider = { item -> item.toString() },
                    lazyModifier = { Modifier.animateItem() },
                    enterTransition = defaultEnterTransition ,
                    exitTransition = defaultExitTransition
                ) { _, item ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        modifier = Modifier.size(45.dp).padding(bottom = VerticalPadding),
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