package com.games.colormix.navigation

enum class Screen {
    HOME,
    Main,
}
sealed class NavigationItem(val route: String) {
    data object Start : NavigationItem(Screen.HOME.name)
    data object Main : NavigationItem(Screen.Main.name)
}