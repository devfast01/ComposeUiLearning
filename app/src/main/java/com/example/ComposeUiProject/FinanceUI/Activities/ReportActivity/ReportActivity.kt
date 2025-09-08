package com.example.ComposeUiProject.Activities.ReportActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.ComposeUiProject.Activities.ReportActivity.screens.ReportScreen
import com.example.ComposeUiProject.ViewModel.MainViewModel
import com.example.ComposeUiProject.ui.theme.Finance_uiTheme

class ReportActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Finance_uiTheme {
                ReportScreen(
                    budgets = mainViewModel.loadBudget(),
                    onBack = { finish() }
                )
            }
        }
    }
}