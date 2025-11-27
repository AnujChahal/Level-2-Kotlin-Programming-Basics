package com.synac.mathappquiz.presentation.quizscreen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Question(val text: String, val answer: Int)

fun generateRandomQuestions(topic: String): List<Question> {
    val questions = mutableListOf<Question>()
    repeat(5) { // 5 random questions per quiz
        val a = Random.nextInt(1, 20)
        val b = Random.nextInt(1, 20)

        when (topic) {
            "Addition" -> questions.add(Question("$a + $b = ?", a + b))
            "Subtraction" -> questions.add(Question("$a - $b = ?", a - b))
            "Multiplication" -> questions.add(Question("$a × $b = ?", a * b))
            "Division" -> {
                val divisor = if (b == 0) 1 else b
                questions.add(Question("$a ÷ $divisor = ?", a / divisor))
            }
        }
    }
    return questions
}

fun saveHighScore(context: Context, topic: String, score: Int) {
    val prefs = context.getSharedPreferences("quiz_scores", Context.MODE_PRIVATE)
    val editor = prefs.edit()
    val currentHigh = prefs.getInt(topic, 0)
    if (score > currentHigh) {
        editor.putInt(topic, score)
        editor.apply()
    }
}

fun getHighScore(context: Context, topic: String): Int {
    val prefs = context.getSharedPreferences("quiz_scores", Context.MODE_PRIVATE)
    return prefs.getInt(topic, 0)
}

@Composable
fun QuizScreen(topic: String) {
    val context = LocalContext.current
    var questions by remember { mutableStateOf(generateRandomQuestions(topic)) }
    var score by remember { mutableStateOf(0) }
    var currentIndex by remember { mutableStateOf(0) }
    var userAnswer by remember { mutableStateOf("") }
    var quizFinished by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("$topic Quiz", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (!quizFinished && currentIndex < questions.size) {
            val question = questions[currentIndex]
            Text(question.text, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = userAnswer,
                onValueChange = { userAnswer = it },
                label = { Text("Your Answer") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                if (userAnswer.toIntOrNull() == question.answer) {
                    score++
                }
                userAnswer = ""
                currentIndex++
                if (currentIndex >= questions.size) {
                    quizFinished = true
                    saveHighScore(context, topic, score)
                }
            }) {
                Text("Submit")
            }
        } else {
            val highScore = getHighScore(context, topic)
            Text("Quiz Finished! Your score: $score/${questions.size}")
            Text("High Score for $topic: $highScore")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                score = 0
                currentIndex = 0
                userAnswer = ""
                quizFinished = false
                questions = generateRandomQuestions(topic)
            }) {
                Text("Restart Quiz")
            }
        }
    }
}
