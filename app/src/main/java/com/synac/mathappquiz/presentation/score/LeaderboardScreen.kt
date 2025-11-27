package com.synac.mathappquiz.presentation.score

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.synac.mathappquiz.presentation.quizscreen.getHighScore

@Composable
fun LeaderboardScreen() {
    val context = LocalContext.current
    val topics = listOf("Addition", "Subtraction", "Multiplication", "Division")

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Leaderboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        topics.forEach { topic ->
            val highScore = getHighScore(context, topic)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("$topic: High Score = $highScore", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
