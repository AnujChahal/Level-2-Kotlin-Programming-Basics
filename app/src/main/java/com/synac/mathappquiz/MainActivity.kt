package com.synac.mathappquiz

import com.synac.mathappquiz.presentation.dashboard.DashboardScreen
import com.synac.mathappquiz.presentation.quizscreen.QuizScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synac.mathappquiz.presentation.score.LeaderboardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathQuizApp()
        }
    }
}

@Composable
fun MathQuizApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen(
                onTopicSelected = { topic -> navController.navigate("quiz/$topic") },
                onLeaderboardSelected = { navController.navigate("leaderboard") }
            )
        }
        composable("quiz/{topic}") { backStackEntry ->
            val topic = backStackEntry.arguments?.getString("topic") ?: "Addition"
            QuizScreen(topic = topic)
        }
        composable("leaderboard") {
            LeaderboardScreen()
        }
    }

}
