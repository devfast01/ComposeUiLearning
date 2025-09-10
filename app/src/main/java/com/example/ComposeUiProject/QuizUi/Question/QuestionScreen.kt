package com.example.ComposeUiProject.QuizUi.Question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.QuizUi.Question.Model.QuestionModel
import com.example.ComposeUiProject.QuizUi.Question.Model.QuestionUiState
import com.example.ComposeUiProject.R


@Composable
fun QuestionScreen(
    questions: List<QuestionModel>,
    onFinish: (finalScore: Int) -> Unit,
    onBackClicked: () -> Unit,
) {
    var state by remember {
        mutableStateOf(QuestionUiState(questions = questions))
    }

    val context = LocalContext.current
    val currentQuestion = state.questions[state.currentIndex]
    var selectedAnswer = currentQuestion.clickedAnswer
    val imageResId = remember(currentQuestion.picPath) {
        context.resources.getIdentifier(
            currentQuestion.picPath ?: "",
            "drawable",
            context.packageName
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey_quiz))
    ) {
        item { // Header item
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onBackClicked }) {
                    Icon(
                        painter = painterResource(R.drawable.back),
                        contentDescription = null
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "Single Player",
                    fontSize = 20.sp,
                    color = colorResource(R.color.navy_blue),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item { // Question
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Question ${state.currentIndex + 1}/10",
                    fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {
                    if (state.currentIndex > 0) {
                        selectedAnswer = null
                        state = state.copy(currentIndex = state.currentIndex - 1)
                    }
                }) {
                    Icon(
                        painter = painterResource(R.drawable.left_arrow),
                        contentDescription = null
                    )
                }

                IconButton(onClick = {
                    if (state.currentIndex == 9) {
                        onFinish(state.score)
                    } else {
                        selectedAnswer = null
                        state = state.copy(currentIndex = state.currentIndex - 1)
                    }
                }) {
                    Icon(
                        painter = painterResource(R.drawable.right_arrow),
                        contentDescription = null
                    )
                }
            }
        }



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