package com.games.colormix.game

import android.content.ClipData
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableItem(label: String, count: Int, @DrawableRes res: Int, progress: Float?=null) {
    LevelInfoCard {
        Row {
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
                LinearProgressIndicator(
                    progress = 0.2f,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .height(8.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }
}