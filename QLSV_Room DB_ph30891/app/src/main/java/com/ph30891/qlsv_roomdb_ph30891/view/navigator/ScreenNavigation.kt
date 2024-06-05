package com.ph30891.qlsv_roomdb_ph30891.view.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ph30891.qlsv_roomdb_ph30891.view.QlsvScreen
import com.ph30891.qlsv_roomdb_ph30891.view.StudentFormScreen

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.QLSVSCREEN.route
    ) {
        composable(Screens.QLSVSCREEN.route) { QlsvScreen(navController = navController) }
        composable(
            "${Screens.UPDATESCREEN.route}/{uid}",
            arguments = listOf(navArgument("uid") { type = NavType.IntType }),
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("uid")
            studentId.let { StudentFormScreen(uid = studentId ?:-1, navController = navController) }
        }
        composable(Screens.ADDSCREEN.route){
            StudentFormScreen(uid = -1, navController = navController)
        }
    }
}