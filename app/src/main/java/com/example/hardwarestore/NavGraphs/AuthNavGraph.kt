package com.example.hardwarestore.NavGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.hardwarestore.Screen.LoadingAnimation
import com.example.hardwarestore.Screen.Login
import com.example.hardwarestore.Screen.Register

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            Login(
                OnLoginClick = {
                    navController.navigate("Loading")
                },
                OnSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            )

        }
        composable(route = "Loading") {
            LoadingAnimation(
                onAnimationComplete = {
                    navController.popBackStack(AuthScreen.Login.route, true)
                    navController.navigate(Graph.HOME)
                }
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            Register(
                OnRegisterClick = {
                    navController.navigate("Loading")
                },
                OnSignInCilck = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
}