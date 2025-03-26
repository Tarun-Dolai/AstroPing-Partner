package org.example.project

import BottomNav
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.NavBar.NavBar1
//import org.example.project.NavBar.BottomNav

@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            topBar = {
                Column {
                    NavBar1()  // Top Navigation Bar
                }
            },
            bottomBar = {
                Column {
                    NavBar1()
                    BottomNav() // Bottom Navigation Bar
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("Hello") // Replace with your dynamic content
            }
        }
    }
}