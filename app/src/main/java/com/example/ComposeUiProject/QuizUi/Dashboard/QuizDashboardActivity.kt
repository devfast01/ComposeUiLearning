package com.example.ComposeUiProject.QuizUi.Dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ComposeUiProject.ui.theme.Finance_uiTheme

class QuizDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Finance_uiTheme {}
        }
    }
}