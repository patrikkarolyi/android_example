package com.example.android_example.data.interactors

import com.example.android_example.data.network.NetworkDataSource
import com.example.android_example.data.network.model.NetworkMovie
import javax.inject.Inject

class MovieInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
){

    suspend fun getMovies(): List<NetworkMovie> {
        return networkDataSource.getMovies()
    }


}