package com.example.ComposeUiProject.QuizUi.Leader

import android.os.Bundle
import android.service.autofill.UserData
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ComposeUiProject.QuizUi.Leader.Model.UserModel
import com.example.ComposeUiProject.R

class LeaderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val topUsers = loadData().take(3)
        val otherUsers = loadData().drop(3)

        setContent {
            LeaderScreen(topUsers, otherUsers, onBackClick = { finish() })
        }
    }

    private fun loadData(): List<UserModel> {
        return listOf(
            UserModel(1, "Sophia", "person1", 8965),
            UserModel(2, "Daniel", "person2", 2589),
            UserModel(3, "James", "person3", 7615),
            UserModel(4, "John Smith", "person4", 3589),
            UserModel(5, "Emily Johnson", "person5", 4068),
            UserModel(6, "David Brown", "person6", 6183),
            UserModel(7, "Sarah Wilson", "person7", 7035),
            UserModel(8, "Michael Davis", "person8", 1085),
            UserModel(9, "Sarah Wilson", "person9", 6489),
            UserModel(10, "Sarah Wilson", "person10", 5045),
        )
    }
}