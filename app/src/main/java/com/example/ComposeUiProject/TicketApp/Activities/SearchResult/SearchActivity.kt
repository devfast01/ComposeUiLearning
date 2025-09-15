package com.example.ComposeUiProject.TicketApp.Activities.SearchResult

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.TicketApp.Activities.Splash.StatusTopBarColor
import com.example.ComposeUiProject.TicketApp.ViewModel.TicketViewModel

class SearchActivity : ComponentActivity() {

    private val viewModel: TicketViewModel by viewModels()
    private var from: String = ""
    private var to: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        from = intent.getStringExtra("from") ?: ""
        to = intent.getStringExtra("to") ?: ""

        setContent {
            StatusTopBarColor()
        }

    }
}