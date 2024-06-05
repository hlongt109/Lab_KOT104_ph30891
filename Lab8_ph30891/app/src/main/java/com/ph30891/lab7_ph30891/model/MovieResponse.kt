package com.ph30891.lab7_ph30891.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("_id")val _id: String,
    @SerializedName("title")val title: String,
    @SerializedName("releaseDate")val releaseDate: String,
    @SerializedName("posterUrl")val posterUrl: String,
    @SerializedName("shotDescription")val shotDescription: String,
    @SerializedName("genre")val genre: String,
    @SerializedName("duration")val duration: String
)