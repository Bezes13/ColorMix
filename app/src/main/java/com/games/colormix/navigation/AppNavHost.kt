package com.games.colormix.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.games.colormix.MainScreen
import com.games.colormix.levelselection.LevelSelectionScreen
import com.games.colormix.start.StartScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Start.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Start.route) {
            StartScreen(navController::navigate)
        }
        composable(NavigationItem.Main.route+"/{levelIndex}",
            arguments = listOf(navArgument("levelIndex") { type = NavType.StringType })) {
            MainScreen(navController::navigate)
        }
        composable(NavigationItem.LevelSelection.route) {
            LevelSelectionScreen(navController::navigate)
        }
    }
}