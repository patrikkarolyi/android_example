package com.example.android_example.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.example.android_example.data.network.model.NetworkMovie

class MovieDiffUtil : DiffUtil.ItemCallback<NetworkMovie>() {
    override fun areItemsTheSame(oldItem: NetworkMovie, newItem: NetworkMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NetworkMovie, newItem: NetworkMovie): Boolean {
        return oldItem == newItem
    }
}