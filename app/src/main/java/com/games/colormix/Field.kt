package com.games.colormix

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Field(content: ColorField?, eventListener: (MainViewEvent) -> Unit) {
    var direction by remember { mutableStateOf(-1) }
    var moved by remember { mutableStateOf(false) }
    val pxToMove = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }
    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pxToMove, 0)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )
    Card(
        shape = RoundedCornerShape(3.dp),
        modifier = Modifier
            .size(FieldSize.dp)
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(3.dp)
            )
            .swipeObserver { eventListener(MainViewEvent.Swipe(it)) }
    ) {
        if (content != null)
            Card(
                colors = CardDefaults.cardColors(containerColor = content.color),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            )
            {
                if(content.highlight) {
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
}

@Composable
@Preview
fun FieldPreview() {
    Field(content = ColorField(2),{})
}

@Composable
@Preview
fun FieldHighlightPreview() {
    Field(content = ColorField(2, highlight = true),{})
}