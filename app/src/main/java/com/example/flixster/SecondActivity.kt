package com.example.flixster

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.serialization.json.Json
import okhttp3.Headers


private const val TAG = "SecondActivity/"
private const val URL = "https://api.themoviedb.org/3/movie/"
private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
class SecondActivity : AppCompatActivity() {
    private lateinit var titleView: TextView
    private lateinit var mediaView: ImageView
    private lateinit var votingView: TextView
    private lateinit var countView: TextView
    private lateinit var descView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_screen)

        // Find the views for the screen
        titleView = findViewById(R.id.titleDetail)
        mediaView = findViewById(R.id.posterDetail)
        votingView = findViewById(R.id.rating)
        countView = findViewById(R.id.voteCount)
        descView = findViewById(R.id.descriptionDetail)

        // Get the extra from the intent
        @Suppress("DEPRECATION")
        val movie = intent.getSerializableExtra(MOVIE_DETAIL) as LatestMovie

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api_key"] = API_KEY
        params["movie_id"] = movie.movie_id as String?
        client.get(URL, params, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to get movie fetch: $statusCode")
            }
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                titleView.text = movie.title
                votingView.text = movie.rating
                countView.text = movie.voteCount
                descView.text = movie.overview
                // Load images into view
                Glide.with(this@SecondActivity)
                    .load(movie.movie_image)
                    .into(mediaView)
            }
        })
    }
}