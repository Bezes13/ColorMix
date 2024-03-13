package com.games.colormix

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun Field(content: ColorField?, pos: Pair<Int, Int>, eventListener: (MainViewEvent) -> Unit) {
    if (content == null){
        return
    }
    val pxToMove = with(LocalDensity.current) {
        (-(FieldSize + VerticalPadding) * (pos.second-content.animateFrom)).toPx().roundToInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if (content.spawned) {
            IntOffset(0, pxToMove)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )

    Card(
            colors = CardDefaults.cardColors(containerColor = content.color),
            modifier = Modifier
                .size(FieldSize)
                .offset {
                    offset
                }
                .clickable(onClick = { eventListener(MainViewEvent.FieldClicked(pos)) })
        )
        {
            if (content.highlight) {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                    Icon(
                        Icons.Filled.Star,
                        "Highlight",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }

}

@Composable
@Preview
fun FieldPreview() {
    Field(content = ColorField(2), Pair(2, 2), {})
}

@Composable
@Preview
fun FieldHighlightPreview() {
    Field(content = ColorField(2, highlight = true), Pair(2, 2), {})
}