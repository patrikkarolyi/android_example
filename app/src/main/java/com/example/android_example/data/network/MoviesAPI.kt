package com.example.android_example.data.network

import com.example.android_example.data.network.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET("popular")
    suspend fun getMovies(
        @Query("api_key") username: String,
        @Query("language") language: String,
        @Query("page") page: String,
    ): NetworkResponse

}