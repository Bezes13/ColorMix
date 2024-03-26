package com.games.colormix.game

import android.content.ClipDescription
import android.widget.Toast
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.games.colormix.R
import com.games.colormix.data.ColorField
import com.games.colormix.data.SpecialType
import com.games.colormix.main.FieldSize
import com.games.colormix.main.MainViewEvent
import com.games.colormix.main.VerticalPadding
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Field(content: ColorField?, pos: Pair<Int, Int>, eventListener: (MainViewEvent) -> Unit) {
    if (content == null) {
        Box(modifier = Modifier.size(FieldSize))
        return
    }
    val pxToMove = with(LocalDensity.current) {
        ((FieldSize + VerticalPadding) * (content.animateTo - pos.second)).toPx().roundToInt()
    }

    val pxDrop = with(LocalDensity.current) {
        (-(FieldSize + VerticalPadding) * (pos.second + 1)).toPx().roundToInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = IntOffset(0, pxToMove),
        animationSpec = TweenSpec(300),
        label = "offset",
        finishedListener = { eventListener(MainViewEvent.SetBlocksAfterAnimation) }
    )

    val dropOffset by animateIntOffsetAsState(
        targetValue = if (content.dropped) IntOffset(0, pxDrop) else IntOffset(0, 0),
        animationSpec = TweenSpec(300),
        label = "offset",
        finishedListener = { }
    )
    val context = LocalContext.current
    Card(
        colors = CardDefaults.cardColors(containerColor = content.color ?: Color.Transparent),
        modifier = Modifier
            .size(FieldSize)
            .offset {
                if (content.animateTo != pos.second) offset else if (content.dropped) IntOffset(
                    0,
                    pxDrop
                ) else dropOffset
            }
            .clickable(onClick = {
                eventListener(MainViewEvent.FieldClicked(pos))
            })
            .dragAndDropTarget(
                shouldStartDragAndDrop = { event ->
                    event
                        .mimeTypes()
                        .contains(ClipDescription.MIMETYPE_TEXT_INTENT)
                },
                target = object : DragAndDropTarget {
                    override fun onDrop(event: DragAndDropEvent): Boolean {
                        if (event.toAndroidDragEvent().clipData.description.label == "bomb"){
                            eventListener(MainViewEvent.UseBomb(pos))
                        }else{
                            if (content.color != null && content.color != Color.Transparent){
                                eventListener(MainViewEvent.UseRubiks(pos))
                            }else{
                                Toast.makeText(context, "Use Rubik just on colored Blocks", Toast.LENGTH_SHORT).show()
                            }
                        }
                        return true
                    }
                }
            ),
    )
    {
        if (content.specialType != SpecialType.None) {
            Image(
                painter = when (content.specialType) {
                    SpecialType.Rock -> painterResource(id = R.drawable.rock)
                    SpecialType.Box -> painterResource(id = R.drawable.box)
                    SpecialType.OpenBox -> painterResource(id = R.drawable.boxopen)
                    else -> painterResource(id = R.drawable.ic_launcher_foreground)
                },
                contentDescription = "SpecialType",
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
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