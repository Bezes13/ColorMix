package com.games.colormix

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

const val FieldSize = 80

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val viewState: MainViewState by mainViewModel.viewState.collectAsState()
    MainScreenContent(

    )
}

@Composable
fun MainScreenContent(
) {
    Column (verticalArrangement = Arrangement.spacedBy(30.dp), modifier = Modifier.fillMaxSize()){
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Column(verticalArrangement = Arrangement.spacedBy(2.dp), modifier = Modifier.align(Alignment.CenterHorizontally)) {
            GameRow()
            GameRow()
            GameRow()
            GameRow()
        }
    }
}

@Composable
fun Field(){
    Card (shape= RoundedCornerShape(3.dp),modifier = Modifier
        .size(FieldSize.dp)
        .border(1.dp, Color.Black, RoundedCornerShape(3.dp))) {}
}

@Composable
fun GameRow(){
    Row (horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        Field()
        Field()
        Field()
        Field()
    }

}

sealed class MainViewDialog {
    data class Dialog( val info: String) : MainViewDialog()
    data object None : MainViewDialog()
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreenContent(

    )
}
