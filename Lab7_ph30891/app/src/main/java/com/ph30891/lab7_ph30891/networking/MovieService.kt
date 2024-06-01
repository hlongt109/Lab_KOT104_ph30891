package com.ph30891.lab7_ph30891.networking

import com.ph30891.lab7_ph30891.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("list-film.php")
    suspend fun getListFilms(): Response<List<MovieResponse>>
}