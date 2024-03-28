package com.games.colormix.game

import android.content.ClipData
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.games.colormix.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableItem(label: String, count: Int, @DrawableRes res: Int, progress: Float?=null) {
    LevelInfoCard {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(id = res),
                contentDescription = label,
                modifier = Modifier
                    .size(60.dp)
                    .dragAndDropSource {
                        detectTapGestures(
                            onPress = {
                                startTransfer(
                                    DragAndDropTransferData(
                                        clipData = ClipData.newIntent(
                                            label,
                                            Intent(label),
                                        )
                                    )
                                )
                            }
                        )
                    }
            )
            Text(
                text = count.toString(),
                fontSize = 25.sp,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
            )
            if(progress != null){
                val animatedPoints by animateFloatAsState(
                    animationSpec = TweenSpec(500),
                    targetValue = progress,
                    label = "points",
                    finishedListener = {}
                )

                LinearProgressIndicator(
                    progress = animatedPoints,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .width(80.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    backgroundColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDraggableItem(){
    DraggableItem(label = "b", count = 3, res = R.drawable.rubik, 0.5f)
}