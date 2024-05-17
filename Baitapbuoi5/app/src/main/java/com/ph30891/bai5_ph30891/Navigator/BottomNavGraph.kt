package com.ph30891.bai5_ph30891.Navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ph30891.bai5_ph30891.View.CartScreen
import com.ph30891.bai5_ph30891.View.HistoryScreen
import com.ph30891.bai5_ph30891.View.HomeScreen
import com.ph30891.bai5_ph30891.View.PersonalScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController ,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
           HomeScreen()
        }
        composable(route = BottomBarScreen.History.route){
            HistoryScreen()
        }
        composable(route = BottomBarScreen.Cart.route){
            CartScreen()
        }
        composable(route = BottomBarScreen.Personal.route){
            PersonalScreen()
        }
    }
}