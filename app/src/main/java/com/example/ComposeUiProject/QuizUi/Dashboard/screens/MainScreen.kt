package com.example.ComposeUiProject.QuizUi.Dashboard.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ComposeUiProject.QuizUi.Dashboard.components.CategoryGrid
import com.example.ComposeUiProject.QuizUi.Dashboard.components.CategoryHeader
import com.example.ComposeUiProject.QuizUi.Dashboard.components.GameModeButtons
import com.example.ComposeUiProject.QuizUi.Dashboard.components.TopUserSection
import com.example.ComposeUiProject.R


@Composable
@Preview
fun MainScreen(
    onSinglePlayerClick: () -> Unit = {},
) {
    val scrollerState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.grey_quiz))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollerState)
        ) {

            TopUserSection()
            Spacer(modifier = Modifier.height(16.dp))
            GameModeButtons(onSinglePlayerClick)
            Spacer(modifier = Modifier.height(32.dp))
            CategoryHeader()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryGrid()

        }
    }
}