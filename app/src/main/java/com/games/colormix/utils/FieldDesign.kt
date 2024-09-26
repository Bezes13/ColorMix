package com.games.colormix.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.games.colormix.R
import com.games.colormix.constants.Padding
import com.games.colormix.data.BlockType

@Composable
fun FieldDesign(
    simpleDesign: Boolean,
    fieldSize: Dp,
    item: BlockType
) {
    if (simpleDesign && !item.special) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = Padding.L),
            modifier = Modifier
                .size(fieldSize)
                ,
        ) {
            val largeRadialGradient = object : ShaderBrush() {
                override fun createShader(size: Size): Shader {
                    return RadialGradientShader(
                        colors = listOf(
                            item.simpleDesign,
                            manipulateColor(color = item.simpleDesign, 0.5f)
                        ),
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
    } else {
        Box(
            modifier = Modifier
                .size(fieldSize),
        ) {
            Image(
                painter = painterResource(id = item.drawId),
                contentDescription = stringResource(R.string.specialtype),
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}