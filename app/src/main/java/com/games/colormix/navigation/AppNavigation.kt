package com.games.colormix.navigation

enum class Screen {
    HOME,
    Main,
    LEVEL_SELECTION
}

sealed class NavigationItem(val route: String) {
    data object Start : NavigationItem(Screen.HOME.name)
    data object Main : NavigationItem(Screen.Main.name)
    data object LevelSelection : NavigationItem(Screen.LEVEL_SELECTION.name)
}