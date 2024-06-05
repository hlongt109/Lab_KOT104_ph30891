package com.ph30891.lab7_ph30891.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

import com.ph30891.lab7_ph30891.ui.theme.Lab7_ph30891Theme
import com.ph30891.lab7_ph30891.view.navigator.ScreenNavigation
import com.ph30891.lab7_ph30891.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7_ph30891Theme {
                val movieViewModel: MovieViewModel = viewModel()
                val moviesState = movieViewModel.movies.observeAsState(initial = emptyList())
               ScreenNavigation()
            }
        }
    }
}
