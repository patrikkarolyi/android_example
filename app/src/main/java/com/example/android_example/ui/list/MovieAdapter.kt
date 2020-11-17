package com.example.android_example.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_example.R
import com.example.android_example.data.network.NetworkDataSource
import com.example.android_example.data.network.model.NetworkMovie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(val movies: List<NetworkMovie>, val listener : Listener? = null) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.titleText
        val ratingText: TextView = itemView.ratingText
        val posterImage: ImageView = itemView.posterImage
        var movieId : Int? = null
        init {
            itemView.setOnClickListener {
                movieId?.let { id -> listener?.onItemSelected(id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = movies[position]
        holder.titleText.text = item.title
        holder.ratingText.text = item.vote_average.toString()
        holder.movieId = item.id

        Glide.with(holder.posterImage)
            .load(NetworkDataSource.image_url_small + item.poster_path)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.posterImage)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface Listener{
        fun onItemSelected(id: Int)
    }
}
