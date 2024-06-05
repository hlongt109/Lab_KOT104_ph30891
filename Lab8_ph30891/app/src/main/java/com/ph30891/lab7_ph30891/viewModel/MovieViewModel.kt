package com.ph30891.lab7_ph30891.viewModel

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
//        _movies.value = Movie.getSampleMovies()
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

    fun getMovieById(filmId: String?): LiveData<Movie?> {
        val liveData = MutableLiveData<Movie?>()
        filmId?.let {
            viewModelScope.launch {
                try {
                    val response = RetrofitService().movieService.getFilmDetails(filmId)
                    if (response.isSuccessful) {
                        liveData.postValue(response.body()?.toMovie())
                    } else {
                        liveData.postValue(null)
                    }
                } catch (e: Exception) {
                    liveData.postValue(null)
                }
            }
        }
        return liveData
    }

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean> = _isSuccess
    fun addFilm(movieRequest: MovieRequest, param: (Any) -> Unit) {
        viewModelScope.launch {
            _isSuccess.value = try {
                val response = RetrofitService().movieService.addFilm(movieRequest)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status == 1) {
                            getMovies()
                            true
                        } else {
                            false
                        }
                    } ?: false
                } else {
                    false
                }
            } catch (e: Exception) {
                false
            }
        }
    }

    fun updateMovie(movieRequest: MovieRequest, param: (Any) -> Unit) {
        viewModelScope.launch {
            _isSuccess.value = try {
                val reponse = RetrofitService().movieService.updateMovie(movieRequest)
                if (reponse.isSuccessful) {
                    reponse.body()?.let {
                        if (it.status == 1) {
                            getMovies()
                            true
                        } else {
                            false
                        }
                    } ?: false
                } else {
                    false
                }
            } catch (e: Exception) {
                false
            }
        }
    }

    fun deleteMovieById(id: String) {
        viewModelScope.launch {
            _isSuccess.value = try {
                val response = RetrofitService().movieService.deleteMovie(id)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status == 1) {
                            getMovies()
                            true
                        } else {
                            false
                        }
                    } ?: false
                } else {
                    false
                }
            } catch (e: Exception) {
                false
            }
        }
    }
}