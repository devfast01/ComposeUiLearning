package com.example.ComposeUiProject.QuizUi.Question

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
import com.example.ComposeUiProject.QuizUi.Question.Model.QuestionModel
import com.example.ComposeUiProject.QuizUi.Score.QuizScoreActivity
import com.example.ComposeUiProject.R

class QuestionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val receivedList = intent.getParcelableArrayListExtra<QuestionModel>("list")
        setContent {
            receivedList?.let {
                QuestionScreen(
                    questions = it,
                    onBackClicked = { finish() },
                    onFinish = { finalScore ->
                        val intent = Intent(this, QuizScoreActivity::class.java)
                        intent.putExtra("Score", finalScore)
                        startActivity(intent)
                        finish()
                    })
            }
        }
    }
}