package com.games.colormix.main.components

import android.content.ClipData
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.games.colormix.R
import com.games.colormix.constants.BlockAnimationDuration
import com.games.colormix.constants.Padding
import com.games.colormix.utils.MyText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableItem(
    label: String,
    count: Int,
    @DrawableRes res: Int,
    cardSize: Dp,
    progress: Float? = null
) {
    val textSize = with(LocalDensity.current) { (cardSize / 1.5f).toSp() }
    LevelInfoCard(modifier = Modifier.height(cardSize)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(3.dp)) {
            Image(
                painter = painterResource(id = res),
                contentDescription = label,
                modifier = Modifier
                    .size(cardSize * 0.9f)
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
            MyText(
                text = count.toString(),
                fontSize = textSize,
                modifier = Modifier.padding(vertical = Padding.M, horizontal = Padding.L)
            )
            if (progress != null) {
                val animatedPoints by animateFloatAsState(
                    animationSpec = TweenSpec(BlockAnimationDuration),
                    targetValue = progress,
                    label = "points",
                    finishedListener = {}
                )

                StripedProgressIndicator(
                    progress = animatedPoints,
                    size = DpSize(cardSize * 1.5f, cardSize * 0.7f)
                )
            }
        }
    }
}

@Composable
fun StripedProgressIndicator(
    modifier: Modifier = Modifier,
    size: DpSize,
    progress: Float,
    stripeColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
    stripeColorSecondary: Color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.5f),
    color: Color = MaterialTheme.colorScheme.primary,
    clipShape: Shape = RoundedCornerShape(16.dp)
) {
    Box(
        modifier = modifier
            .clip(clipShape)
            .background(createStripeBrush(stripeColor, stripeColorSecondary, Padding.M))
            .height(size.height)
            .width(size.width)
    ) {
        Box(
            modifier = Modifier
                .clip(clipShape)
                .background(color)
                .fillMaxHeight()
                .fillMaxWidth(progress)
        )
    }
}

@Composable
private fun createStripeBrush(
    stripeColor: Color,
    stripeBg: Color,
    stripeWidth: Dp
): Brush {
    val stripeWidthPx = with(LocalDensity.current) { stripeWidth.toPx() }
    val brushSizePx = 2 * stripeWidthPx
    val stripeStart = stripeWidthPx / brushSizePx

    return Brush.linearGradient(
        stripeStart to stripeBg,
        stripeStart to stripeColor,
        start = Offset(0f, 0f),
        end = Offset(brushSizePx, brushSizePx),
        tileMode = TileMode.Repeated
    )
}

@Preview
@Composable
fun PreviewDraggableItem() {
    DraggableItem(label = "b", count = 3, res = R.drawable.rubik, 30.dp, 0.5f)
}