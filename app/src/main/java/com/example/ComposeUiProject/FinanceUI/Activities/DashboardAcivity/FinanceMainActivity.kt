package com.example.ComposeUiProject.Activities.DashboardAcivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.ComposeUiProject.Activities.DashboardAcivity.screens.MainScreen
import com.example.ComposeUiProject.Activities.ReportActivity.ReportActivity
import com.example.ComposeUiProject.ViewModel.MainViewModel
import com.example.ComposeUiProject.ui.theme.Finance_uiTheme

class FinanceMainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Finance_uiTheme {
                MainScreen(
                    expenses = mainViewModel.loadData(),
                    onCardClick = {
                        startActivity(Intent(this, ReportActivity::class.java))
                    })
            }
        }
    }
}

//+99362997686