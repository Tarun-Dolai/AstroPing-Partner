package org.example.project.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Sample data model
data class OrderData(
    val name: String,
    val gender: String,
    val dob: String,
    val tob: String,
    val pob: String,
    val duration: String,
    val rate: String,
    val languages: String
)

@Composable
fun OrdersScreen() {
    val orders = listOf(
        OrderData("Vishnu Rathod Bajrang", "Male", "2000-05-26", "04:00 AM", "Pdpl", "01:00 min", "₹ 2", "English"),
        OrderData("Rohit Sharma", "Male", "1995-11-15", "02:30 PM", "Mumbai", "00:45 min", "₹ 5", "Hindi, English")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())  // for  scrollable content we need to use it
    ) {
        orders.forEach { order ->
            OrderCard(order)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun OrderCard(order: OrderData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF2E5), shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        // Top Part Of Card
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("AstroPing", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                tint = Color(0xFFD07C50),
                modifier = Modifier
                    .size(20.dp)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("2025-02-27 (04:41 PM)", fontSize = 14.sp)

        Spacer(modifier = Modifier.height(12.dp))

        Column {
            InfoRow("Name", order.name)
            InfoRow("Gender", order.gender)
            InfoRow("Date Of Birth", order.dob)
            InfoRow("Time of Birth", order.tob)
            InfoRow("Place of Birth", order.pob)
            InfoRow("Duration", order.duration)
            InfoRow("Rate", order.rate)
            InfoRow("Languages", order.languages)

            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                Text("Kundali: ", fontWeight = FontWeight.Bold)
                Text(
                    "View Kundali",
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { /* Handle click here */ }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle Accept Chat click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD07C50))
        ) {
            Text("Accept Chat", color = Color.White)
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, fontWeight = FontWeight.Bold)
        Text(value)
    }
}
