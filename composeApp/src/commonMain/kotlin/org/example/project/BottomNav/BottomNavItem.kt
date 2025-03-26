package org.example.project.BottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Orders : BottomNavItem("orders", Icons.Default.ShoppingCart, "Orders")
    object Chat : BottomNavItem("chat", Icons.Default.Email, "Chat")
    object Call : BottomNavItem("call", Icons.Default.Call, "Call")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}
