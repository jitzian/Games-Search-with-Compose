package com.example.gamessearchwithcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gamessearchwithcompose.ui.details.views.DetailsScreenState
import com.example.gamessearchwithcompose.ui.home.views.HomeScreen
import com.example.gamessearchwithcompose.ui.search.views.SearchScreenState

@Composable
fun AppNavigation(
    startDestination: String = AppDestinations.HOME_ROUTE,
    routes: AppDestinations = AppDestinations
) {
    val navController = rememberNavController()
    val actions = remember(navController) {
        AppActions(navController, routes)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            AppDestinations.HOME_ROUTE
        ) {
            HomeScreen(
                navigateToSearch = actions.navigateToSearch
            )
        }

        composable(
            AppDestinations.SEARCH_ROUTE
        ) {
            SearchScreenState(selectedGameId = actions.selectedGame, navigateUp = actions.navigateUp)
        }

        composable(
            route = "${AppDestinations.GAME_DETAIL_ROUTE}/{${routes.GAME_DETAIL_ID_KEY}}",
            arguments = listOf(
                navArgument(
                    routes.GAME_DETAIL_ID_KEY
                ) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val gameId = arguments.getInt(routes.GAME_DETAIL_ID_KEY)
            DetailsScreenState(
                id = gameId,
                onBackButton = actions.navigateUp
            )
        }
    }
}