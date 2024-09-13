package com.games.colormix.screens.sign

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.constants.BackgroundBlocks
import com.games.colormix.data.ColorField
import com.games.colormix.data.randomBlock
import com.games.colormix.navigation.Screen
import com.games.colormix.screens.start.Background
import com.games.colormix.utils.MyTextField

@Composable
fun SignInScreen(navigate: (String) -> Unit, viewModel: AuthViewModel = hiltViewModel()) {
    var signedIn by remember { mutableStateOf(false) }

    val width = LocalConfiguration.current.screenWidthDp.dp
    var id = 0
    val background by remember {
        mutableStateOf((1 until BackgroundBlocks).map {
            Array(BackgroundBlocks * 2) { ColorField(id++, randomBlock()) }
                .toList()
        })
    }
    val simpleDesign =
        LocalContext.current.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
            .getBoolean("Design", false)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Background(
            fieldSize = width / BackgroundBlocks,
            backGround = background,
            simpleDesign = simpleDesign
        )

        MyTextField(stringResource(R.string.game_start), onClick = {
            viewModel.signInAnonymously(it) { success ->
                signedIn = success
            }
            navigate(Screen.HOME.name)
        })

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnonymousSignIn() {
    SignInScreen({})
}


