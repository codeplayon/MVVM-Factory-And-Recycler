package com.example.mvvmfactoryandrecycler.Reposotery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmfactoryandrecycler.Models.PostResponse
import com.example.mvvmfactoryandrecycler.Network.Api
import com.example.mvvmfactoryandrecycler.Network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepo(private var retro:RetroInstance) {

    private var mutableList = MutableLiveData<List<PostResponse>>()

    val list :LiveData<List<PostResponse>>
    get() = mutableList

    fun postMethodCall(){
        var call = retro.getPosts().create(Api::class.java)

        call.getPosts().enqueue(object :Callback<List<PostResponse>>{
            override fun onResponse(
                call: Call<List<PostResponse>>,
                response: Response<List<PostResponse>>
            ) {
                mutableList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
            }

        })
    }

}