package com.example.gamessearchwithcompose.data.di.modules.games

import com.example.gamessearchwithcompose.data.repository.modules.games.GamesRepositoryImpl
import com.example.gamessearchwithcompose.domain.repository.games.GamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GamesRepositoryModule {
    @Binds
    @Singleton
    abstract fun gamesRepository(gamesRepository: GamesRepositoryImpl): GamesRepository
}