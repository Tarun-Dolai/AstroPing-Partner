import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.Screens.CallScreen
import org.example.project.Screens.OrdersScreen
import org.example.project.Screens.ProfileScreen

@Composable
fun BottomNav() {
    var selectedScreen by remember { mutableStateOf("Orders") }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD07C50))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                val items = listOf("Orders", "Chat", "Call", "Profile")
                val icons = listOf(
                    Icons.Default.ShoppingCart,
                    Icons.Default.Email,
                    Icons.Default.Call,
                    Icons.Default.Person
                )

                items.forEachIndexed { index, item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable { selectedScreen = item }
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = item,
                            tint = if (selectedScreen == item) Color.White else Color.LightGray
                        )
                        Text(
                            text = item,
                            color = if (selectedScreen == item) Color.White else Color.LightGray
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (selectedScreen) {
                "Orders" -> OrdersScreen()
                "Chat" -> ChatScreen()
                "Call" -> CallScreen()
                "Profile" -> ProfileScreen()
            }
        }
    }
}