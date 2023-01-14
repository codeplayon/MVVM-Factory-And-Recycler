package com.example.mvvmfactoryandrecycler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmfactoryandrecycler.Reposotery.PostRepo
import com.example.mvvmfactoryandrecycler.ViewModel.PostViewModel

class PostViewModelFactory(private val repo: PostRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(repo) as T
    }
}