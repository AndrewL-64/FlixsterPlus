package com.example.flixster

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class MovieDetails(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("rating")
    var rating: String? = null,
    @SerializedName("tagline")
    var tagline:String? = null,
    @SerializedName("vote_count")
    var voteCount:String? = null
) : java.io.Serializable