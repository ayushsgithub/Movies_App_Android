package com.example.moviesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.moviesapp.api.ApiMovie

class MovieAdapter(private val context: Context, private val movies: List<ApiMovie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.itemView.apply {
            val movieOverview = findViewById<TextView>(R.id.movieOverview)
            movieOverview.text = movie.overview
            val movieTitle = findViewById<TextView>(R.id.movieTitle)
            movieTitle.text = movie.title
            val moviePoster = findViewById<ImageView>(R.id.moviePoster)
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/original" + movie.poster_path)
                .into(moviePoster)
        }
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
