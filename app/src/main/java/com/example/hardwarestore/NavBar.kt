@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hardwarestore

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.ContentAlpha
import com.example.hardwarestore.NavGraphs.BottomNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        topBar = {
            val (title, icon) = when (currentDestination?.route) {
                BottomBarScreen.Home.route -> "Tech." to Icons.Default.Menu
                BottomBarScreen.Categories.route -> "Categories" to Icons.Default.Home
                BottomBarScreen.Order.route -> "Order" to Icons.Default.Home
                BottomBarScreen.ContactUs.route -> "Contact Us" to Icons.Default.Home
                BottomBarScreen.Settings.route -> "Settings" to Icons.Default.Home
                else -> "Tech" to Icons.Default.Menu
            }


            MyTopBar(title, icon,navController)
        },

        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}
@Composable
fun MyTopBar(title: String, navigationIcon: ImageVector,navController: NavHostController) {
    TopAppBar(

        title = {
            Text(title, modifier = Modifier,style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        },
        navigationIcon = {
            IconButton(onClick = {if (navController.previousBackStackEntry != null) {
                navController.popBackStack()
            }
            }) {
                Icon(imageVector = navigationIcon, contentDescription = "")
            }
        },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "User Account"
                    )
                }
        }
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Categories,
        BottomBarScreen.Order,
        BottomBarScreen.ContactUs,
        BottomBarScreen.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val badgeCount = when (screen) {
        BottomBarScreen.Home -> 0 // Set badge count for Home screen
        BottomBarScreen.Categories -> 0 // No badge for Profile screen
        BottomBarScreen.Order -> 2 // Set badge count for Settings screen
        BottomBarScreen.Settings -> 2
        BottomBarScreen.ContactUs -> 0
    }

    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            if (badgeCount > 0) {
                BadgedBox(badge = {
                    Badge {
                        Text(text ="$badgeCount")
                    }
                }) {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation Icon"
                    )
                }
            } else {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = "Navigation Icon"
                )
            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
        ),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}