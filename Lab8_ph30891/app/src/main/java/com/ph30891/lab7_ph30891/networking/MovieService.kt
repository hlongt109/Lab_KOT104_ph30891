package com.ph30891.lab7_ph30891.networking

import com.ph30891.lab7_ph30891.model.MovieRequest
import com.ph30891.lab7_ph30891.model.MovieResponse
import com.ph30891.lab7_ph30891.model.StatusResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("/api/get-list-movies")
    suspend fun getListFilms(): Response<List<MovieResponse>>

    @GET("/api/get-movie-by-id/{id}")
    suspend fun getFilmDetails(@Path("id")id:String):Response<MovieResponse>

    @POST("/api/add-movie")
    suspend fun addFilm(@Body filmRequest: MovieRequest):Response<StatusResponse>

    @PUT("/api/update-movie")
    suspend fun updateMovie(@Body filmRequest: MovieRequest):Response<StatusResponse>

    @DELETE("/api/delete-movie-by-id/{id}")
    suspend fun deleteMovie(@Path("id")id:String):Response<StatusResponse>
}