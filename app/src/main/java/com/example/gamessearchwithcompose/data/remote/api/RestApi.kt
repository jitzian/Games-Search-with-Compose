package com.example.gamessearchwithcompose.data.remote.api

import com.example.gamessearchwithcompose.data.remote.model.ResulApiSingleGame
import com.example.gamessearchwithcompose.data.remote.model.ResultApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RestApi {
    @GET("games/")
    suspend fun fetchGames(@QueryMap queryMap: Map<String, String>): ResultApi

    @GET("game/{id}/?")
    suspend fun fetchGameDetailsById(
        @Path("id") id: String,
        @QueryMap queryMap: Map<String, String>
    ): ResulApiSingleGame
}