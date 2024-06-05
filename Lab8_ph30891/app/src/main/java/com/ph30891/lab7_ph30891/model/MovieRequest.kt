package com.ph30891.lab7_ph30891.model

data class MovieRequest(
    val id: String? = null,
    val title: String,
    val releaseDate: String,
    val posterUrl: String,
    val shotDescription: String,
    val genre: String,
    val duration: String
)
