package com.games.colormix.screens.start.tutorial.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.games.colormix.constants.Padding
import com.games.colormix.screens.main.components.DraggableItem
import com.games.colormix.utils.MyText

@Composable
fun PowerUpTutorialItem(title: String, explanation: String, @DrawableRes res: Int, progress: Float? = null) {

        LazyColumn {
            item {
                MyText(text = title, fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
                Spacer(modifier = Modifier.size(Padding.L))
                MyText(text = explanation)
            }
        }
        DraggableItem(title, 3, res, 60.dp, progress )

}