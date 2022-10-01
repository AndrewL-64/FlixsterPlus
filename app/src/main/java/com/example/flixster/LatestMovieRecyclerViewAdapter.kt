package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LatestMovieRecyclerViewAdapter(
    private val movies: List<LatestMovie>,
    ) : RecyclerView.Adapter<LatestMovieRecyclerViewAdapter.MovieViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_movie, parent, false)
            return MovieViewHolder(view)
        }

        //Inner class lets us refer to all the different view elements

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: LatestMovie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.title) as TextView
        val mPoster: ImageView = mView.findViewById<View>(R.id.poster) as ImageView
        val mDesc: TextView = mView.findViewById<View>(R.id.description) as TextView
    }

    /**
     * Binding each View in the ViewHolder to its' actual data
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mDesc.text = movie.overview

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/" + movie.movie_image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .centerCrop()
            .into(holder.mPoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}