package com.example.ComposeUiProject.QuizUi.Question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ComposeUiProject.QuizUi.Question.Model.QuestionModel
import com.example.ComposeUiProject.QuizUi.Question.Model.QuestionUiState
import com.example.ComposeUiProject.R


@Composable
fun QuestionScreen(
    questions: List<QuestionModel>,
    onFinish: (finalScore: Int) -> Unit,
    onBackClicked: () -> Unit,
) {
    val state by remember {
        mutableStateOf(QuestionUiState(questions = questions))
    }

    val context = LocalContext.current
    val currentQuestion = state.questions[state.currentIndex]
    val selectedAnswer = currentQuestion.clickedAnswer
    val imageResId = remember(currentQuestion.picPath) {
        context.resources.getIdentifier(
            currentQuestion.picPath ?: "",
            "drawable",
            context.packageName
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = colorResource(R.color.grey_quiz))
    ) {

    }

}

@Preview
@Composable
fun QuestionScreenPreview() {
    val questions = listOf(
        QuestionModel(
            id = 1,
            question = "What is the capital of France?",
            answer_1 = "Paris",
            answer_2 = "London",
            answer_3 = "Berlin",
            answer_4 = "Madrid",
            correctAnswer = "Paris",
            score = "10",
            picPath = "",
            clickedAnswer = ""
        )
    )
    QuestionScreen(questions = questions, onFinish = {}, onBackClicked = {})
}