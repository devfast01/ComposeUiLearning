package com.example.ComposeUiProject.Activities.IntroActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ComposeUiProject.Activities.IntroActivity.screens.IntroScreen
import com.example.ComposeUiProject.Activities.DashboardAcivity.FinanceMainActivity
import com.example.ComposeUiProject.ui.theme.Finance_uiTheme

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Finance_uiTheme {
                IntroScreen(onStartClick = {
                    startActivity(Intent(this, FinanceMainActivity::class.java))
                })
            }
        }
    }
}