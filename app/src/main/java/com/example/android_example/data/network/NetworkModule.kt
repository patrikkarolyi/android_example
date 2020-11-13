package com.example.android_example.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkDataSource.baseUrl)
        .client(OkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    fun provideNytAPI(retrofit: Retrofit): MoviesAPI = retrofit.create(MoviesAPI::class.java)

}