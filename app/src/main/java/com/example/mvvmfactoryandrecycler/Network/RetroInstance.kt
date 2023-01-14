package com.example.mvvmfactoryandrecycler.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun getPosts(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}