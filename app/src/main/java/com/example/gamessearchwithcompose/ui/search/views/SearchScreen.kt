@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.gamessearchwithcompose.ui.search.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gamessearchwithcompose.ui.app.UIGamesApp
import com.example.gamessearchwithcompose.ui.search.viewmodel.SearchViewModel
import com.example.gamessearchwithcompose.ui.search.viewmodel.UIState

@Composable
fun SearchScreenState(
    selectedGameId: (Int) -> Unit,
    navigateUp: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.collectAsState()

    SearchScreen(
        selectedGameId = selectedGameId,
        navigateUp = navigateUp,
        viewModel = viewModel,
        uiState = uiState.value
    )

}

@Composable
fun SearchScreen(
    selectedGameId: (Int) -> Unit,
    navigateUp: () -> Unit,
    viewModel: SearchViewModel,
    uiState: UIState
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val closeKeyboard = {
        keyboardController?.hide()
    }
    UIGamesApp {
        Scaffold(topBar = {
            SearchAppBar(navigateUp = navigateUp, viewModel = viewModel, closeKeyboard)
        }) { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                // Show progress while search is happening
                val isLoadingData = !uiState.isSearchingResults && uiState.data.isEmpty()

                //ShowSearchProgress(isLoadingData)
                // Main content for this screen
                SearchScreenContent(uiState.data, selectedGameId, closeKeyboard)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevSearchScreen() {

}