package com.example.ComposeUiProject.QuizUi.Dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContextCompat
import com.example.ComposeUiProject.QuizUi.Dashboard.screens.MainScreen
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.ui.theme.Finance_uiTheme

class QuizDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        setContent {
            MainScreen(
                onSinglePlayerClick = {},
                onBoardClick = {}
            )
        }
    }
}