package com.example.ComposeUiProject.QuizUi.Dashboard.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ComposeUiProject.QuizUi.Dashboard.components.Banner
import com.example.ComposeUiProject.QuizUi.Dashboard.components.CategoryGrid
import com.example.ComposeUiProject.QuizUi.Dashboard.components.CategoryHeader
import com.example.ComposeUiProject.QuizUi.Dashboard.components.GameModeButtons
import com.example.ComposeUiProject.QuizUi.Dashboard.components.QuizBottomNavigationBar
import com.example.ComposeUiProject.QuizUi.Dashboard.components.TopUserSection
import com.example.ComposeUiProject.R


@Composable
@Preview
fun QuizMainScreen(
    onSinglePlayerClick: () -> Unit = {},
    onBoardClick: () -> Unit = {},
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

            Spacer(modifier = Modifier.height(20.dp))
            TopUserSection()
            Spacer(modifier = Modifier.height(16.dp))
            GameModeButtons(onSinglePlayerClick)
            Spacer(modifier = Modifier.height(32.dp))
            CategoryHeader()
            CategoryGrid()
            Spacer(modifier = Modifier.height(24.dp))
            Banner()
        }
        QuizBottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onItemSelected = { itemId ->
                {
                    Log.d("BoardClick", "Board Clicked")

                    if (itemId == R.id.board) {
                        onBoardClick()
                    }
                }()
            })
    }
}