# Level 2: Kotlin Programming Basics 🚀

This repository demonstrates **Kotlin programming fundamentals** through a console-based **Math Quiz App**.  
It covers variables, functions, classes, conditions & loops, and collections (Lists, Maps, Arrays) in a practical project.

---

## 📌 Problem Statement
Design and implement a **Math Quiz App** in Kotlin that:
- Displays a dashboard with math topics (Addition, Subtraction, Multiplication, Division).
- Allows users to select a topic and attempt a quiz.
- Generates questions dynamically and evaluates user answers.
- Tracks scores and provides feedback.

---

## 🔄 Solution Workflow
1. **Dashboard Screen**  
   - Lists available math topics.  
   - User selects a topic to start the quiz.

2. **Quiz Screen**  
   - Generates random math questions based on the chosen topic.  
   - Provides multiple-choice answers for user selection.  
   - Evaluates correctness and updates score.  
   - Displays final score and high score tracking.

3. **High Score Tracking**  
   - Uses `SharedPreferences` (in Android version) or variables (console version) to store best scores.  

4. **Restart Option**  
   - Allows replaying the quiz without restarting the app.

---

## 🛠 Tech Stack
- **Language**: Kotlin  
- **IDE**: Android Studio (for Compose version) / IntelliJ IDEA (for console version)  
- **Frameworks**: Jetpack Compose (UI for Android version)  
- **Core Concepts**:  
  - Variables, Functions, Classes  
  - Conditions & Loops  
  - Lists, Maps, Arrays  

---

## 🏗 Architecture
- **MainActivity** → Entry point, sets up navigation.  
- **DashboardScreen** → Displays topics.  
- **QuizScreen** → Handles question generation, answer evaluation, scoring.  
- **Question Data Class** → Encapsulates question text, correct answer, and options.  
- **SharedPreferences** → Stores high scores (Android version).  

Flow Diagram:
MainActivity → DashboardScreen → QuizScreen → High Score → Restart


---

## 🎯 Relevance and Learning
This project is designed to strengthen **Kotlin basics** through hands-on practice:
- Applying **variables, functions, and classes** in real scenarios.  
- Using **conditions and loops** for quiz logic.  
- Managing **collections (Lists, Maps, Arrays)** for topics and questions.  
- Understanding **state management** in Jetpack Compose.  
- Building a **complete app workflow** from dashboard to quiz evaluation.  

By completing this project, learners gain confidence in both **console-based Kotlin programming** and **Android app development fundamentals**.

---

## 📂 Project Structure
Level-2-Kotlin-Programming-Basics/ 
│── MainActivity.kt 
│── DashboardScreen.kt 
│── QuizScreen.kt 
│── Question.kt

<img width="250" height="600" alt="Screenshot 2025-11-27 132328" src="https://github.com/user-attachments/assets/59183084-f8f8-416f-a7a8-c363ff209636" />
<img width="250" height="600" alt="Screenshot 2025-11-27 132337" src="https://github.com/user-attachments/assets/c63ff8a6-a597-40b4-8102-798594896576" />
<img width="250" height="600" alt="Screenshot 2025-11-27 132408" src="https://github.com/user-attachments/assets/52cccf09-e4db-4042-9f5f-d53d0f5c01c8" />

---

## 🚀 Future Enhancements
- Add more math topics (fractions, algebra, geometry).  
- Implement a **Leaderboard screen** showing all high scores.  
- Add **animations and progress indicators** for better UX.  
- Expand to a **multi-level quiz system** with difficulty settings.  
