package com.ph30891.lab7_ph30891.model.entities

import com.google.gson.annotations.SerializedName
import com.ph30891.lab7_ph30891.model.Movie
import com.ph30891.lab7_ph30891.model.MovieRequest
import com.ph30891.lab7_ph30891.model.MovieResponse
import com.ph30891.lab7_ph30891.view.components.MovieFormData

fun MovieResponse.toMovie(): Movie {
    return Movie(
        id = this._id,
        title = this.title,
        duration = this.duration,
        releaseDate = this.releaseDate,
        genre = this.genre,
        shotDescription = this.shotDescription,
        posterUrl = this.posterUrl
    )
}
fun MovieFormData.toMovieRequest(): MovieRequest {
    val filmIdInt = try {
        this.id?.toString()
    } catch (e: Exception) {
        null
    }
//    val durationInt = try {
//        this.duration.toInt()
//    } catch (e: NumberFormatException) {
//        0
//    }
    return MovieRequest(
        id = filmIdInt,
        title = this.title,
        duration = this.duration,
        releaseDate = this.releaseDate,
        genre = this.genre,
        shotDescription = this.shotDescription,
        posterUrl = this.posterUrl
    )
}
fun Movie?.toMovieFormData()=this?.let {
    MovieFormData(
        this.id,
        this.title,
        this.duration,
        this.releaseDate,
        this.genre,
        this.shotDescription,
        this.posterUrl
    )
}