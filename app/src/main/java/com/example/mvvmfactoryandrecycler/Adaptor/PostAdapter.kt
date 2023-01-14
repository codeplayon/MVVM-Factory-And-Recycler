package com.example.mvvmfactoryandrecycler.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmfactoryandrecycler.Models.PostResponse
import com.example.mvvmfactoryandrecycler.databinding.PostRowBinding

class PostAdapter(var list:List<PostResponse>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding:PostRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostRowBinding.inflate(LayoutInflater.from(parent.context))
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.tvBody.text = list[position].body
        holder.binding.tvTitle.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }
}