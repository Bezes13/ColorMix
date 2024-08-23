package com.games.colormix.screens.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.games.colormix.R
import com.games.colormix.navigation.Screen
import com.games.colormix.screens.main.MainViewEvent
import com.games.colormix.utils.MyText

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopAppBar(
    eventListener: (MainViewEvent) -> Unit,
    navigate: (String) -> Unit
) {
    androidx.compose.material3.TopAppBar(
        title = {
            MyText(
                text = stringResource(id = R.string.app_name),
                fontSize = MaterialTheme.typography.headlineLarge.fontSize
            )
        },
        actions = {
            IconButton(onClick = { eventListener(MainViewEvent.Retry) }) {
                Icon(Icons.Default.Refresh, stringResource(R.string.menu))
            }
            IconButton(onClick = { navigate(Screen.HOME.name) }) {
                Icon(Icons.Default.Menu, stringResource(R.string.menu))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    )
}