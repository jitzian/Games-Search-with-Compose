package com.example.gamessearchwithcompose.ui.navigation

import androidx.navigation.NavHostController

class AppActions(
    private val navController: NavHostController,
    private val routes: AppDestinations
) {
    // Triggered when user tries to navigate to details of an game from list with Id.
    val selectedGame: (Int) -> Unit = { gameId: Int ->
        navController.navigate("${routes.GAME_DETAIL_ROUTE}/$gameId")
    }

    // Navigates to SearchScreen
    val navigateToSearch = {
        navController.navigate(routes.SEARCH_ROUTE)
    }

    // Navigates to previous screen from current screen.
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}