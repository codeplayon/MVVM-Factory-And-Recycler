package com.example.mvvmfactoryandrecycler.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfactoryandrecycler.Models.PostResponse
import com.example.mvvmfactoryandrecycler.Reposotery.PostRepo

class PostViewModel(private val repo :PostRepo):ViewModel() {

    fun repoCall(){
        repo.postMethodCall()
    }

    val list :LiveData<List<PostResponse>>
    get() = repo.list
}