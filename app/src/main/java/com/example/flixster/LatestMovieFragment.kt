package com.example.flixster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener

private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"

class LatestMovieFragment : Fragment(), OnListFragmentInteractionListener {
    //Making the view
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.list) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        updateAdapter(progressBar, recyclerView)
        return view
    }

    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView) {
        progressBar.show()

        // Create and setup an AsyncHTTPClient() here
        val client = AsyncHttpClient()
        var params = RequestParams()
        params["api_key"] = API_KEY

        //Perform a HTTP request
        client [
            "https://api.themoviedb.org/3/movie/now_playing",
            params,
            object : JsonHttpResponseHandler()
            {
                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JsonHttpResponseHandler.JSON
                ) {
                    progressBar.hide()

                    //Parse JSON into Models
                    val results = json.jsonObject.get("results")
                    val moviesJSON = results.toString()
                    val gson = Gson()

                    val arrayMovieType = object : TypeToken<List<LatestMovie>>() {}.type
                    val models : List<LatestMovie> = gson.fromJson(moviesJSON, arrayMovieType)

                    recyclerView.adapter = LatestMovieRecyclerViewAdapter(models, this@LatestMovieFragment)
                    Log.d("LatestMovieFragment", "response successful")
                }
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    response: String,
                    throwable: Throwable?
                ) {
                    progressBar.hide()

                    // If error is not null, log it!
                    throwable?.message?.let {
                        Log.e("LatestMovieFragment", response)
                    }
                }
            }
        ]
    }
    override fun onItemClick(item: LatestMovie) {
        Toast.makeText(context, "test: " + item.title, Toast.LENGTH_LONG).show()
    }
}