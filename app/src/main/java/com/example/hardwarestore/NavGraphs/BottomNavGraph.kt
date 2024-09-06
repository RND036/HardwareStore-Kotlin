package com.example.hardwarestore.NavGraphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hardwarestore.BottomBarScreen
import com.example.hardwarestore.Screen.Categories
import com.example.hardwarestore.Screen.Contact
import com.example.hardwarestore.Screen.HomePage
import com.example.hardwarestore.Screen.Order
import com.example.hardwarestore.Screen.Settings

@Composable
fun BottomNavGraph(navController: NavHostController) {
    var darkTheme by remember { mutableStateOf(false) }
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomePage()
        }
        composable(route = BottomBarScreen.Categories.route) {
            Categories()
        }
        composable(route = BottomBarScreen.Order.route) {
            Order()
        }
        composable(route = BottomBarScreen.ContactUs.route) {
            Contact()

        }
        composable(route = BottomBarScreen.Settings.route) {
            Settings(darkTheme = darkTheme, onThemeUpdated = {darkTheme=!darkTheme})



        }
    }
}