import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Transaction(
    val status: String,
    val amount: String,
    val date: String,
    val statusColor: Color,
    val icon: @Composable () -> Unit
)

@Composable
fun TransactionsScreen() {
    val transactions = listOf(
        Transaction("pending", "₹ 100", "26-03-2025 12:12 PM", Color.Green) {
            Icon(Icons.Default.Done, contentDescription = "Pending", tint = Color.Green)
        },
        Transaction("failure", "₹ 20", "26-03-2025 12:11 PM", Color.Red) {
            Icon(Icons.Default.Close, contentDescription = "Failure", tint = Color.Red)
        },
        Transaction("success", "₹ 594", "26-03-2025 12:11 PM", Color.Green) {
            Icon(Icons.Default.CheckCircle, contentDescription = "Success", tint = Color.Green)
        }
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF2E5))
            .padding(16.dp)
    ) {
        items(transactions) { transaction ->
            TransactionCard(transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            transaction.icon()

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = "debit", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = transaction.date, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = transaction.status,
                color = transaction.statusColor,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = transaction.amount,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
