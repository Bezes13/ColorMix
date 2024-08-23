package com.games.colormix.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.games.colormix.constants.BorderWidth
import com.games.colormix.constants.Padding
import com.games.colormix.utils.MyText

@Composable
fun LevelDoneDialog(
    buttonTextId: Int,
    headerTextId: Int,
    bodyText: String,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = onConfirm) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(5.dp, MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Padding.L),
                modifier = Modifier.padding(Padding.L),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyText(
                    text = stringResource(id = headerTextId),
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Divider(color = MaterialTheme.colorScheme.secondary)
                MyText(text = bodyText)
                Button(
                    onClick = onConfirm,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.tertiary,
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    border = BorderStroke(BorderWidth, MaterialTheme.colorScheme.tertiary)
                ) {
                    MyText(text = stringResource(id = buttonTextId))
                }
            }
        }
    }
}