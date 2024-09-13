package com.games.colormix.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.games.colormix.constants.BorderWidthLarge
import com.games.colormix.constants.MenuButtonShape

@Composable
fun MyTextField(submitText: String, onClick: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = if (it.length > 7) text else it },
            label = { MyText("Name") },
            colors = TextFieldDefaults.colors()
        )
        ElevatedButton(
            modifier = Modifier
                .border(width = BorderWidthLarge, color = Color.Black, shape = MenuButtonShape),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
            ),
            onClick = { onClick(text) }
        ) {
            MyText(
                text = submitText,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun MyTextFieldRow(
    submitText: String,
    initText: String = "",
    height: Dp,
    onClick: (String) -> Unit
) {

    var text by remember { mutableStateOf(initText) }
    LaunchedEffect(initText){
        text = initText
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            singleLine = true,
            value = "  $text",
            textStyle = TextStyle(fontFamily = lonelyCoffeeFamily),
            onValueChange = { text = if (it.length > 15) text else it.trim() },
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f),
                    RoundedCornerShape(40f)
                )
                .fillMaxWidth(0.3f).padding(vertical = 7.dp)

        )
        ElevatedButton(
            modifier = Modifier.height(height),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
            ),
            onClick = { onClick(text) }
        ) {
            MyText(
                text = submitText,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@Preview
fun TextFieldPreview() {
    MyTextField("Start Game") {}
}