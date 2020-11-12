package com.example.android_example.data.network

import com.example.android_example.data.network.model.NetworkResponse

class NetworkDataSource(
    private val moviesAPI : MoviesAPI
){

    companion object{
        val baseUrl = "https://api.themoviedb.org/3/movie/"
        val urlPopular = "popular"
        val urlTopRated = "top_rated"
        val urlDetails = ""

        val API_KEY = "8d61230b01928fe55a53a48a41dc839b"
        val language = "en-US"
        val page = "1"

        val image_url_small= "https://image.tmdb.org/t/p/w342/"
        val image_url_large= "https://image.tmdb.org/t/p/original/"
    }

    suspend fun getMovies(): NetworkResponse? {
        return moviesAPI.getMovies(
            API_KEY,
            language,
            page
        )
    }


}