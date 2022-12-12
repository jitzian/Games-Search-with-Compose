package com.example.gamessearchwithcompose.data.di.modules.network

import com.example.gamessearchwithcompose.BuildConfig
import com.example.gamessearchwithcompose.constants.GlobalConstants
import com.example.gamessearchwithcompose.data.remote.api.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesApi(): RestApi {
        return Retrofit.Builder()
            .baseUrl(GlobalConstants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(setupOkHttpClient())
            .build()
            .create(RestApi::class.java)
    }

    //Setup OkHttp client and logger interceptor
    private fun setupOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpLoggingInterceptor.setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BASIC
            }
        )
        return httpClient.build()
    }

}