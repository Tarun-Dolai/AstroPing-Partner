package org.example.project.SubPagesOfMenuitems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun OrdersScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),  // Optional background color for clarity
        contentAlignment = Alignment.Center
    ) {
        Text("Orders Screen", fontSize = 24.sp)
    }
}
