package com.ph30891.lab7_ph30891.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ph30891.lab7_ph30891.model.Movie
import com.ph30891.lab7_ph30891.model.MovieRequest
import com.ph30891.lab7_ph30891.model.entities.toMovie
import com.ph30891.lab7_ph30891.networking.RetrofitService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.getListFilms()
                if (response.isSuccessful) {
                    _movies.postValue(response.body()?.map { it.toMovie() })
                } else {
                    _movies.postValue(emptyList())
                }
            } catch (e: Exception) {
                Log.e("Tag", "getMovies :" + e.message)
                _movies.postValue(emptyList())
            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun getMovieById(id: String): LiveData<Movie?> {
        val livedata = MutableLiveData<Movie?>()
            viewModelScope.launch {
                try {
                    val response = RetrofitService().movieService.getFilmDetails(id)
                    if (response.isSuccessful) {
                        livedata.postValue(response.body()?.toMovie())
                    } else {
                        livedata.postValue(null)
                    }
                } catch (e: Exception) {
                    Log.e("Tag", "getMovieDetails: " + e.message)
                    livedata.postValue(null)
                }
            }
        return livedata
    }

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean> = _isSuccess
    fun addFilm(movieRequest: MovieRequest,onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.addFilm(movieRequest)
                if (response.isSuccessful && response.body()?.status == 200) {
                    getMovies()
                    onResult(true)
                } else {
                    onResult(false)
                }
            } catch (e: Exception) {
                Log.e("Tag", "addMovie: " + e.message)
                onResult(false)
            }
        }
    }

    fun updateMovie(movieRequest: MovieRequest,onResult: (Boolean) -> Unit ) {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.updateMovie(movieRequest)
                if (response.isSuccessful && response.body()?.status == 200) {
                    getMovies()
                    onResult(true)
                } else {
                    onResult(false)
                }
            } catch (e: Exception) {
                Log.e("Tag", "updateMovie: " + e.message)
                onResult(false)
            }
        }
    }

    fun deleteMovieById(id: String,onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.deleteMovie(id)
                if (response.isSuccessful && response.body()?.status == 200) {
                    getMovies()
                    onResult(true)
                } else {
                    onResult(false)
                }
            } catch (e: Exception) {
                Log.e("Tag", "deleteMovie: " + e.message)
                onResult(false)
            }
        }
    }
}