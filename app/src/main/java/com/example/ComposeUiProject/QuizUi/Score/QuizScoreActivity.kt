package com.example.ComposeUiProject.QuizUi.Score

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ComposeUiProject.QuizUi.Dashboard.QuizDashboardActivity
import com.example.ComposeUiProject.R

class QuizScoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val score = intent.getIntExtra("Score", 0)

        setContent {
            ScoreScreen(score) {
                startActivity(Intent(this, QuizDashboardActivity::class.java))
                finish()
            }
        }
    }
}