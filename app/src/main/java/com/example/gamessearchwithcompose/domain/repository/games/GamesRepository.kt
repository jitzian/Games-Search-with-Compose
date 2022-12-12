package com.example.gamessearchwithcompose.domain.repository.games

import com.example.gamessearchwithcompose.data.remote.model.ResulApiSingleGame
import com.example.gamessearchwithcompose.data.remote.model.ResultApi

interface GamesRepository {
    suspend fun fetchGames(gameName: String): ResultApi
    suspend fun fetchGameDetailsById(id: Int): ResulApiSingleGame
}