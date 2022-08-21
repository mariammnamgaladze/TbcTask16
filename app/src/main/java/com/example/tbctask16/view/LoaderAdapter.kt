package com.example.tbctask16.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbctask16.databinding.LoaderBinding

class LoaderAdapter : LoadStateAdapter<LoaderAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(
        LoaderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class LoadStateViewHolder(private val binding: LoaderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            binding.root.isVisible = loadState is LoadState.Loading
        }
    }
}