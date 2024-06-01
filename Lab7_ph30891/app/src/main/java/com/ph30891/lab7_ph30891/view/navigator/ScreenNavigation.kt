package com.ph30891.lab7_ph30891.view.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ph30891.lab7_ph30891.model.Movie
import com.ph30891.lab7_ph30891.utils.ScreenList
import com.ph30891.lab7_ph30891.view.LoginScreen
import com.ph30891.lab7_ph30891.view.MovieScreen
import com.ph30891.lab7_ph30891.view.Screen1
import com.ph30891.lab7_ph30891.view.Screen2
import com.ph30891.lab7_ph30891.view.Screen3
import com.ph30891.lab7_ph30891.viewModel.MainViewModel

@Composable
fun ScreenNavigation(){
    val navController = rememberNavController()
    
    val mainViewModel: MainViewModel = viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())

    NavHost(
        navController = navController,
        startDestination = ScreenList.LOGINSCREEN.route
    ){
        composable(ScreenList.LOGINSCREEN.route){ LoginScreen(navController = navController)}
        composable(ScreenList.SCREEN1.route){ Screen1(navController = navController)}
        composable(ScreenList.SCREEN2.route){ Screen2(navController = navController) }
        composable(ScreenList.SCREEN3.route){ Screen3(navController = navController) }
        composable(ScreenList.MVCREEN.route){ MovieScreen(movies = moviesState.value,navController)}
    }
}