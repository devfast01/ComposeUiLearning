package com.example.ComposeUiProject.TicketApp.Activities.TicketDetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.TicketApp.Activities.Dashboard.TicketDashboardActivity
import com.example.ComposeUiProject.TicketApp.Activities.Splash.SplashScreen
import com.example.ComposeUiProject.TicketApp.Domain.FlightModel

@Suppress("DEPRECATION")
class TicketDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)

        val flight = intent.getSerializableExtra("flight") as FlightModel

        setContent {
            TicketDetailScreen(
                flight = flight,
                onBackClick = { finish() },
                onDownloadTicketClick = {
                    // Handle download click
                }
            )
        }
    }
}