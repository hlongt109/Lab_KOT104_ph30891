package com.ph30891.lab7_ph30891.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ph30891.lab7_ph30891.utils.ScreenList

@Composable
fun Screen1(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable { navController.navigate(ScreenList.SCREEN2.route){
                popUpTo(ScreenList.SCREEN1.route){inclusive = true} // clear màn hình 1 không có người dùng quay lại
            } },
        contentAlignment = Alignment.Center
    ) {
        Text("Screen 1", color = Color.White, fontSize = 20.sp)
    }
}