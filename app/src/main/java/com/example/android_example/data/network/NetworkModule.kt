package com.example.android_example.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkModule {

    //provide
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkDataSource.baseUrl)
        .client(OkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    //provide
    fun provideNytAPI(retrofit: Retrofit): MoviesAPI = retrofit.create(MoviesAPI::class.java)

}