package com.example.ComposeUiProject.QuizUi.Leader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ComposeUiProject.QuizUi.Leader.Model.UserModel
import com.example.ComposeUiProject.QuizUi.Leader.components.LeaderRow
import com.example.ComposeUiProject.QuizUi.Leader.components.OnBackRow
import com.example.ComposeUiProject.QuizUi.Leader.components.TopThreeSection
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
        item {
            TopThreeSection(topUsers)
            Spacer(modifier = Modifier.height(16.dp))
        }
        itemsIndexed(otherUsers) { index, user ->
            LeaderRow(user, index + 4)
        }

    }
}

@Preview
@Composable
fun LeaderScreenPreview() {
    val topUsers = listOf(UserModel(4, "John Smith", "person1", 8589),
        UserModel(4, "John Smith", "person1", 8589),
        UserModel(4, "John Smith", "person1", 8589))
    val otherUsers = listOf(
        UserModel(8, "Michael Davis", "person2", 1085),
        UserModel(9, "Sarah Wilson", "person3", 6489),
        UserModel(10, "Sarah Wilson", "person4", 5045),
    )

    LeaderScreen(topUsers, otherUsers) { }
}