package com.games.colormix.utils

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit

@Composable
fun MyText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    lineHeight: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    fontWeight: FontWeight? = null,
    color: Color = Color.Black
    ) {
    Text(
        text = text,
        fontFamily = lonelyCoffeeFamily,
        color = color,
        fontSize = fontSize,
        style = style,
        modifier = modifier,
        textAlign = textAlign,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        lineHeight = lineHeight,
        textDecoration = textDecoration,
        fontWeight = fontWeight
    )
}