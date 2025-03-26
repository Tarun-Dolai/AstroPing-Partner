import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class OrderData(
    val name: String,
    val gender: String,
    val dob: String,
    val tob: String,
    val pob: String,
    val duration: String,
    val rate: String,
    val languages: String,
    val status: String
)

@Composable
fun ChatScreen() {
    val orders = remember {
        listOf(
            OrderData("Sanju", "Male", "1999-09-08", "01:00 AM", "Hyderabad", "986:00 min", "₹ 5", "English", "Cancelled"),
            OrderData("Devika", "Male", "2001-10-31", "10:30 AM", "Ponnur", "19996:00 min", "₹ 5", "English", "Completed"),
            OrderData("Devika", "Male", "2001-10-31", "10:30 AM", "Ponnur", "19991:00 min", "₹ 5", "English", "Expired")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        orders.forEach { order ->
            OrderCard(order)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun OrderCard(order: OrderData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
            .background(Color(0xFFFFF2E5)) // Clear solid background color
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(0xFFFFF2E5) // Same color for entire card
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " AstroPing",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Chat Icon",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("2025-03-24 (03:49PM)", fontSize = 14.sp)

            Spacer(modifier = Modifier.height(12.dp))

            // Details
            Column(modifier = Modifier.padding(start = 8.dp)) {
                InfoRow("Name", order.name)
                InfoRow("Gender", order.gender)
                InfoRow("Date Of Birth", order.dob)
                InfoRow("Time of Birth", order.tob)
                InfoRow("Place of Birth", order.pob)
                InfoRow("Duration", order.duration)
                InfoRow("Rate", order.rate)
                InfoRow("Languages:", order.languages)
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = Color.Gray)

            Spacer(modifier = Modifier.height(8.dp))

            // Footer
            Text(
                text = when (order.status) {
                    "Cancelled" -> "This session was cancelled"
                    "Completed" -> "This session was ended"
                    "Expired" -> "This order was expired"
                    else -> ""
                },
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray,
                fontSize = 14.sp
            )

            if (order.status == "Completed" || order.status == "Expired") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { /* Action */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (order.status == "Completed") Color(0xFFFFA726) else Color.Red
                        ),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = if (order.status == "Completed") "Chat completed" else "Expired",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = value, fontSize = 14.sp)
    }
}
