package com.games.colormix.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.games.colormix.R
import com.games.colormix.constants.Padding
import com.games.colormix.data.ColorField
import com.games.colormix.screens.main.components.animations.LazyAnimatedColumn
import com.games.colormix.utils.FieldDesign


@Composable
fun Background(
    fieldSize: Dp,
    backGround: List<List<ColorField>>,
    simpleDesign: Boolean
) {
    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = stringResource(R.string.specialtype),
        alignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillHeight
    )
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
                FieldDesign(simpleDesign, fieldSize, item.type)
            }
        }
    }
}