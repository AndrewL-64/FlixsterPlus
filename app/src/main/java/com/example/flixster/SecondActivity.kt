package com.example.flixster

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_screen)
        // Find the views for the screen
        val titleDetail = findViewById<TextView>(R.id.detailTitle)
        val posterView = findViewById<ImageView>(R.id.posterDetail)
        val ratingView = findViewById<TextView>(R.id.rating)
        val voteCountView = findViewById<TextView>(R.id.voteCount)
        val descView = findViewById<TextView>(R.id.descriptionDetail)
        val dateView = findViewById<TextView>(R.id.releaseDate)

        val movie = intent.getSerializableExtra(MOVIE_DETAIL) as MovieDetails

        val ratingT = getString(R.string.rating, movie.vote_average)
        val voteC = getString(R.string.count, movie.vote_count)
        val dateV = getString(R.string.date, movie.release_date)

        titleDetail.text = movie.title
        ratingView.text = ratingT
        voteCountView.text = voteC
        descView.text = movie.overview
        dateView.text = dateV

        //Load the image
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + movie.movie_image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .centerCrop()
            .into(posterView)
    }
}