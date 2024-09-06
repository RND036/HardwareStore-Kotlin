package com.example.hardwarestore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home,
    )

    object Categories : BottomBarScreen(
        route = "categories",
        title = "Categories",
        icon = Icons.Default.Category,
    )

    object Order : BottomBarScreen(
        route = "order",
        title = "Order",
        icon = Icons.Default.ShoppingCart,

        )
    object ContactUs : BottomBarScreen(
        route = "contactus",
        title = "ContactUs",
        icon = Icons.Default.Phone,

        )
    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings,

        )
}