package com.example.ComposeUiProject.QuizUi.Leader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ComposeUiProject.QuizUi.Leader.Model.UserModel
import com.example.ComposeUiProject.QuizUi.Leader.components.OnBackRow
import com.example.ComposeUiProject.R


@Composable
fun LeaderScreen(
    topUsers: List<UserModel>,
    otherUsers: List<UserModel>,
    onBackClick: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey_quiz)),
        verticalArrangement = Arrangement.Top
    ) {

        item {
            OnBackRow(onBackClick)
        }

    }
}

@Preview
@Composable
fun LeaderScreenPreview() {
    val topUsers = listOf(UserModel(4, "John Smith", "person1", 8589))
    val otherUsers = listOf(
        UserModel(8, "Michael Davis", "person2", 1085),
        UserModel(9, "Sarah Wilson", "person3", 6489),
        UserModel(10, "Sarah Wilson", "person4", 5045),
    )

    LeaderScreen(topUsers, otherUsers) { }
}