package com.example.gamessearchwithcompose.ui.home.views

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.gamessearchwithcompose.ui.app.UIGamesApp

@Composable
fun HomeScreen(navigateToSearch: () -> Unit) {
    UIGamesApp {
        Scaffold(
            topBar = { HomeTopAppBar(navigateToSearch = navigateToSearch) }
        ) {
            //TODO: Implement recent searches using cache (Room database)
        }
    }
}
