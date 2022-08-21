package com.example.tbctask16.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tbctask16.R
import com.example.tbctask16.databinding.ItemLayoutBinding
import com.example.tbctask16.model.DataModel

class MyAdapter: PagingDataAdapter<DataModel.UserData, MyAdapter.UserViewHolder>(UserItemCallback) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class UserViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val user = getItem(bindingAdapterPosition)
            binding.apply {
                Glide.with(binding.root)
                    .load(user?.avatar ?: "")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(phUser)
                tvName.text = user?.firstName.plus(" ").plus(user?.lastName)
                tvEmail.text = user?.email
            }
        }
    }

    private object UserItemCallback : DiffUtil.ItemCallback<DataModel.UserData>() {
        override fun areItemsTheSame(
            oldItem: DataModel.UserData,
            newItem: DataModel.UserData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataModel.UserData,
            newItem: DataModel.UserData
        ): Boolean {
            return oldItem == newItem
        }
    }
}
