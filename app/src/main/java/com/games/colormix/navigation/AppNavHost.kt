package com.games.colormix.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.games.colormix.MainScreen
import com.games.colormix.MainViewModel
import com.games.colormix.start.StartScreen
import com.games.colormix.start.StartViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Start.route,
    main: MainViewModel,
    start: StartViewModel,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Start.route) {
            StartScreen(navController, start)
        }
        composable(NavigationItem.Main.route+"/{levelIndex}",
            arguments = listOf(navArgument("levelIndex") { type = NavType.IntType })) {
            MainScreen(main)
        }

    }
}