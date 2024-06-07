package com.ph30891.lab7_ph30891.view.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ph30891.lab7_ph30891.utils.ScreenList
import com.ph30891.lab7_ph30891.view.LoginScreen
import com.ph30891.lab7_ph30891.view.MovieScreen
import com.ph30891.lab7_ph30891.view.Screen1
import com.ph30891.lab7_ph30891.view.Screen2
import com.ph30891.lab7_ph30891.view.Screen3
import com.ph30891.lab7_ph30891.view.components.MovieFromSreen
import com.ph30891.lab7_ph30891.viewModel.MovieViewModel

@Composable
fun ScreenNavigation(){
    val navController = rememberNavController()
    
    val movieViewModel: MovieViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = ScreenList.MVCREEN.route
    ){
        composable(ScreenList.LOGINSCREEN.route){ LoginScreen(navController = navController)}
        composable(ScreenList.MVCREEN.route){ MovieScreen(navController,movieViewModel)}
        composable(ScreenList.ADD.route){ MovieFromSreen(
            navController = navController,
            movieViewModel = movieViewModel,
            id = ""
        )}
        composable(
            "${ScreenList.EDIT.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType }),
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("id")?.let { id ->
                MovieFromSreen(navController, movieViewModel, id)
            }
        }
    }
}