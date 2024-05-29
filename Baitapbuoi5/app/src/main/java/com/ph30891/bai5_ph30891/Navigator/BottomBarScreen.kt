package com.ph30891.bai5_ph30891.Navigator

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object History: BottomBarScreen(
        route = "history",
        title = "History",
        icon = Icons.Default.List
    )
    object Cart : BottomBarScreen(
        route = "cart",
        title = "Cart",
        icon = Icons.Default.ShoppingCart
    )
    object Personal : BottomBarScreen(
        route = "personal",
        title = "Personal",
        icon = Icons.Default.Person
    )
    object Favorite : BottomBarScreen(
        route = "favorites",
        title = "",
        icon =  Icons.Default.Person
    )
}