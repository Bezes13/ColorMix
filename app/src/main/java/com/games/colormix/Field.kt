package com.games.colormix

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun Field(content: ColorField?, pos: Pair<Int, Int>, eventListener: (MainViewEvent) -> Unit) {
    if (content == null) {
        Box(modifier = Modifier.size(FieldSize))//.background(Color.Black))
        return
    }
    val pxToMove = with(LocalDensity.current) {
        ((FieldSize + VerticalPadding) * ( content.animateTo - pos.second)).toPx().roundToInt()
    }

    val pxDrop = with(LocalDensity.current) {
        (-(FieldSize + VerticalPadding) * (pos.second+1)).toPx().roundToInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = IntOffset(0, pxToMove),
        label = "offset",
        finishedListener = {eventListener(MainViewEvent.SetBlocksAfterAnimation)}
    )

    val dropOffset by animateIntOffsetAsState(
        targetValue = if(content.dropped) IntOffset(0, pxDrop) else IntOffset(0, 0),
        label = "offset",
        finishedListener = {eventListener(MainViewEvent.ResetSpawns)}
    )


    Card(
        colors = CardDefaults.cardColors(containerColor = content.color),
        modifier = Modifier
            .size(FieldSize)
            .offset {
                if (content.animateTo != pos.second) offset else if(content.dropped) IntOffset(0, pxDrop) else dropOffset
            }
            .clickable(onClick = { eventListener(MainViewEvent.FieldClicked(pos)) })
    )
    {
    }

}

@Composable
@Preview
fun FieldPreview() {
    Field(content = ColorField(2, animateTo = 2), Pair(2, 2), {})
}

@Composable
@Preview
fun FieldHighlightPreview() {
    Field(content = ColorField(2, highlight = true, animateTo = 3), Pair(2, 2), {})
}