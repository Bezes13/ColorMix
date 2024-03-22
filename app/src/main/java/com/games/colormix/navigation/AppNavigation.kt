package com.games.colormix.navigation

enum class Screen {
    HOME,
    Main,
    LEVELSELECTION
}
sealed class NavigationItem(val route: String) {
    data object Start : NavigationItem(Screen.HOME.name)
    data object Main : NavigationItem(Screen.Main.name)
    data object LevelSelection : NavigationItem(Screen.LEVELSELECTION.name)
}