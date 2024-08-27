package com.games.colormix.screens.main.components

import android.content.ClipDescription
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.games.colormix.R
import com.games.colormix.data.BlockType.Empty
import com.games.colormix.data.ColorField
import com.games.colormix.screens.main.MainViewEvent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Field(
    block: ColorField,
    size: Dp,
    pos: Pair<Int, Int>,
    eventListener: (MainViewEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    if (block.type == Empty) {
        Box(modifier = modifier.size(size))
        return
    }

    val context = LocalContext.current
    val bombString = stringResource(id = R.string.bomb_item)
    Box(
        modifier = modifier
            .size(size)
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
                        if (event.toAndroidDragEvent().clipData.description.label == bombString
                        ) {
                            eventListener(MainViewEvent.UseBomb(pos))
                        } else {
                            if (!block.type.special) {
                                eventListener(MainViewEvent.UseRubiks(pos))
                            } else {
                                Toast
                                    .makeText(
                                        context,
                                        context.getString(R.string.use_rubik_error),
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        }
                        return true
                    }
                }
            ),
    )
    {
        Image(
            painter = painterResource(id = block.type.drawId),
            contentDescription = stringResource(R.string.specialtype),
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
fun FieldPreview() {
    Field(block = ColorField(2), 40.dp, Pair(2, 2), {})
}

@Composable
@Preview
fun FieldHighlightPreview() {
    Field(block = ColorField(2), 50.dp, Pair(2, 2), {})
}