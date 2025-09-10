package com.example.ComposeUiProject.QuizUi.Question.Model

data class QuestionUiState(
    val questions: List<QuestionModel>,
    val currentIndex: Int = 0,
    val score: Int = 0,
)
