package com.example.gamessearchwithcompose.data.repository.modules.games

import com.example.gamessearchwithcompose.constants.GlobalConstants.Companion.API_KEY
import com.example.gamessearchwithcompose.data.remote.api.RestApi
import com.example.gamessearchwithcompose.data.remote.model.ResulApiSingleGame
import com.example.gamessearchwithcompose.data.remote.model.ResultApi
import com.example.gamessearchwithcompose.domain.repository.games.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(private val restApi: RestApi) : GamesRepository {
    override suspend fun fetchGames(gameName: String): ResultApi {
        return restApi.fetchGames(
            mapOf(
                "api_key" to API_KEY,
                "filter" to "name:$gameName",
                "format" to "json"
            )
        )
    }

    override suspend fun fetchGameDetailsById(id: Int): ResulApiSingleGame {
        return restApi.fetchGameDetailsById(
            id = id.toString(),
            mapOf(
                "api_key" to API_KEY,
                "format" to "json"
            )
        )
    }
}