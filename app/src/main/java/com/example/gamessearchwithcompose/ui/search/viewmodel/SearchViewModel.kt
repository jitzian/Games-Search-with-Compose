package com.example.gamessearchwithcompose.ui.search.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamessearchwithcompose.data.remote.model.ResultGame
import com.example.gamessearchwithcompose.domain.repository.games.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val gamesRepository: GamesRepository,
    private val application: Application
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    fun fetchGames(query: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val data = gamesRepository.fetchGames(query)
            _state.value = UIState(
                data = data.resultGames,
                isSearchingResults = false
            )
        }
    }
}

data class UIState(
    val data: List<ResultGame> = emptyList(),
    val isSearchingResults: Boolean = false
)