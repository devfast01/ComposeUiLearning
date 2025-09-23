package com.example.ComposeUiProject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.Activities.IntroActivity.IntroActivity
import com.example.ComposeUiProject.NeonBottomNavBar.NeonBottomNavBarActivity
import com.example.ComposeUiProject.Domain.MainItems
import com.example.ComposeUiProject.HomeApp.HomeMainActivity
import com.example.ComposeUiProject.QuizUi.Dashboard.QuizDashboardActivity
import com.example.ComposeUiProject.TicketApp.Activities.Splash.TicketSplashActivity
import com.example.ComposeUiProject.ui.theme.Finance_uiTheme

class MainActivity : ComponentActivity() {
    val mainItems = mutableListOf(
        MainItems(title = "Finance UI", pic = "btn_1", onCardClick = {
            startActivity(Intent(this, IntroActivity::class.java))
        }),
        MainItems(title = "Quiz UI", pic = "quiz", onCardClick = {
            startActivity(Intent(this, QuizDashboardActivity::class.java))
        }),
        MainItems(title = "Home App", pic = "home_blue", onCardClick = {
            startActivity(Intent(this, HomeMainActivity::class.java))
        }),
        MainItems(title = "Ticket App", pic = "from_ic", onCardClick = {
            startActivity(Intent(this, TicketSplashActivity::class.java))
        }),
        MainItems(title = "Beautiful Nav Bar", pic = "ticket_bottom_btn1", onCardClick = {
            startActivity(Intent(this, NeonBottomNavBarActivity::class.java))
        }
        ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Finance_uiTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 150.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(items = mainItems) { item -> MainItem(item) }
                    }
                }
            }
        }
    }
}

@SuppressLint("LocalContextResourcesRead", "DiscouragedApi")
@Composable
fun MainItem(
    item: MainItems,
) {
    Box(modifier = Modifier.clickable { item.onCardClick() }) {
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(size = 12.dp))
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val context = LocalContext.current

            Image(
                painter = painterResource(
                    context.resources.getIdentifier(
                        item.pic, "drawable", context.packageName
                    )
                ), contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(55.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorResource(R.color.lightBlue))
                    .padding(12.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.darkBlue)
                )
            }
            Image(
                painter = painterResource(
                    R.drawable.arrow_right
                ), contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorResource(R.color.lightBlue))
                    .padding(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun MainItemPreview() {
    val mainItems = mutableListOf(
        MainItems(title = "Finance UI", pic = "btn_1"),
        MainItems(title = "Quiz UI", pic = "quiz"),
        MainItems(title = "Home App", pic = "home_blue"),
        MainItems(title = "Ticket App", pic = "from_ic")
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 150.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = mainItems) { item -> MainItem(item) }
        }
    }
}
