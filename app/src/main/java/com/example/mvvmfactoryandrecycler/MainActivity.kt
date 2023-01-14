package com.example.mvvmfactoryandrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmfactoryandrecycler.Adaptor.PostAdapter
import com.example.mvvmfactoryandrecycler.Network.RetroInstance
import com.example.mvvmfactoryandrecycler.Reposotery.PostRepo
import com.example.mvvmfactoryandrecycler.ViewModel.PostViewModel
import com.example.mvvmfactoryandrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retro = RetroInstance
        val repo = PostRepo(retro)

        viewModel = ViewModelProvider(this,PostViewModelFactory(repo))[PostViewModel::class.java]

        viewModel.repoCall()
        viewModel.list.observe(this@MainActivity){
            binding.recyclerView.adapter = PostAdapter(it)
            binding.recyclerView.layoutManager = LinearLayoutManager(this)

            Log.d("TAG", "onCreate: $it")
        }

    }
}