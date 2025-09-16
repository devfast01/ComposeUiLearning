package com.example.ComposeUiProject.TicketApp.Activities.SeatSelect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.TicketApp.Activities.Dashboard.TicketMainScreen
import com.example.ComposeUiProject.TicketApp.Domain.FlightModel

@Suppress("DEPRECATION")
class SeatSelectActivity : ComponentActivity() {
    private lateinit var flight: FlightModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        flight = intent.getSerializableExtra("flight") as FlightModel
        setContent {
            SeatListScreen(flight = flight, onBackClick = {
                finish()
            }, onConfirm = {})
        }
    }
}