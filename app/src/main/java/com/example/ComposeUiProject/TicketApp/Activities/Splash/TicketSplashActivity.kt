package com.example.ComposeUiProject.TicketApp.Activities.Splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.ComposeUiProject.HomeApp.HomeMainActivity
import com.example.ComposeUiProject.R

@SuppressLint("CustomSplashScreen")
class TicketSplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        setContent {
            SplashScreen(onGetStartedClick = {
                startActivity(Intent(this, TicketMainActivity::class.java))
            })
        }
    }
}

@Composable
fun SplashScreen(onGetStartedClick: () -> Unit = {}) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayout() {
            val (backgroundImg, title, subtitle, startBtn) = createRefs()
            Image(
                painter = painterResource(R.drawable.splash_bg),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backgroundImg) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxSize()
            )
            val styledText = buildAnnotatedString {
                append("Discover your \nDream")
                withStyle(style = SpanStyle(color = colorResource(R.color.orange_ticket))) {
                    append(" Flight")
                }
                append(" \nEasily")
            }
            Text(
                text = styledText,
                fontSize = 53.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .padding(horizontal = 16.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = "Find an easy way to buy airplane " +
                        "tickets with just a few click in the application.\n",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.orange_ticket),
                modifier = Modifier
                    .padding(top = 32.dp, start = 16.dp)
                    .constrainAs(subtitle) {
                        top.linkTo(title.bottom)
                        start.linkTo(title.start)
                    }
            )

            Box(
                modifier = Modifier.constrainAs(startBtn) {
                    bottom.linkTo(parent.bottom)
                }
            ) {
                GradientButton(onGetStartedClick, "Get Started", 32)
            }

        }
    }

}

// Find an easy way to buy airplane tickets with just a few click in the application.

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}