package com.example.fleetmanagement.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import com.example.fleetmanagement.data.model.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Maps",
            icon = Icons.Filled.LocationOn,
            route = "home"
        ),
        BottomNavItem(
            label = "Dashboard",
            icon = Icons.Filled.Home,
            route = "dashboard"
        ),
    )
}