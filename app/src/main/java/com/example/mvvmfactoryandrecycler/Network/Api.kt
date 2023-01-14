package com.example.mvvmfactoryandrecycler.Network

import com.example.mvvmfactoryandrecycler.Models.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getPosts(): Call<List<PostResponse>>
}