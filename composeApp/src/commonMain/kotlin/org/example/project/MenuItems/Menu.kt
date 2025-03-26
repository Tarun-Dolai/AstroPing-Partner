package org.example.project.MenuItems

import TransactionsScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.SubPagesOfMenuitems.CallHistoryScreen
import org.example.project.SubPagesOfMenuitems.ChatHistoryScreen
import org.example.project.SubPagesOfMenuitems.LoginHistoryScreen
import org.example.project.SubPagesOfMenuitems.LogoutScreen
import org.example.project.SubPagesOfMenuitems.OrdersHistoryScreen
import org.example.project.SubPagesOfMenuitems.OrdersScreen
import org.example.project.SubPagesOfMenuitems.PreferredTimeScreen
import org.example.project.SubPagesOfMenuitems.Withdraw

@Composable
fun Menu() {
    var selectedScreen by remember { mutableStateOf<String?>(null) }  // No default page

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            // Profile Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(text = "Vishnu", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = "9701083573", fontSize = 14.sp, color = Color.Gray)
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { selectedScreen = "Profile" }
                )
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // Menu Items
            val menuItems = listOf(
                "Orders" to Icons.Default.ShoppingCart,
                "Orders History" to Icons.Default.ShoppingCart,
                "Chat History" to Icons.Default.Email,
                "Call History" to Icons.Default.Call,
                "Preferred time" to Icons.Default.ThumbUp,
                "Login History" to Icons.Default.Star,
                "Withdraw" to Icons.Default.Add,
                "Transactions" to Icons.Default.Done
            )

            menuItems.forEach { (title, icon) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedScreen = title }
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Logout Button
            Text(
                text = "Logout",
                color = Color.Red,
                modifier = Modifier.clickable { selectedScreen = "Logout" }
            )
        }

        // Screen Rendering Logic - Show screen only if selectedScreen is not null
        selectedScreen?.let {
            when (it) {
                "Orders" -> OrdersScreen()
                "Orders History" -> OrdersHistoryScreen()
                "Chat History" -> ChatHistoryScreen()
                "Call History" -> CallHistoryScreen()
                "Preferred time" -> PreferredTimeScreen()
                "Login History" -> LoginHistoryScreen()
                "Withdraw" -> Withdraw()
                "Transactions" -> TransactionsScreen()
                "Logout" -> LogoutScreen()
                "Profile" -> Text("Profile Screen", modifier = Modifier.fillMaxSize())
            }
        }
    }
}