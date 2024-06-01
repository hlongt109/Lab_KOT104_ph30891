package com.ph30891.lab7_ph30891.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
}