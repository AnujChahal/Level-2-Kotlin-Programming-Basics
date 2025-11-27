package com.synac.mathappquiz.presentation.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(onTopicSelected: (String) -> Unit, onLeaderboardSelected: () -> Unit) {
    val topics = listOf("Addition", "Subtraction", "Multiplication", "Division")

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Math Quiz Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        topics.forEach { topic ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onTopicSelected(topic) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = topic, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onLeaderboardSelected() }) {
            Text("View Leaderboard")
        }
    }
}
