package com.example.ComposeUiProject.Activities.DashboardAcivity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.R


@Composable
@Preview
fun CardSection(onClick: () -> Unit = {}) {

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(230.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.card),
            contentDescription = "cardImage",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(R.drawable.sim),
            contentDescription = "simImage",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(all = 16.dp),
        )

        Image(
            painter = painterResource(R.drawable.visa),
            contentDescription = "simImage",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(all = 16.dp),
        )

        Text(
            text = "1234 5678 9012 3456",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align(
                    Alignment.CenterStart
                )
                .padding(start = 16.dp, bottom = 16.dp)
        )

        Text(
            text = "03/07",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align(
                    Alignment.CenterEnd
                )
                .padding(end = 16.dp, bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 90.dp)
                .align(Alignment.BottomCenter)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 60.dp,
                        bottomEnd = 12.dp
                    )
                ) // TODO pay attention there
                .background(Color.White.copy(alpha = 0.2f))
                .padding(all = 16.dp)

        ) {
            Column() {
                Text(
                    text = "Your Balance",
                    color = Color.White, fontSize = 17.sp
                )

                Text(
                    text = "$ 23,451.58",
                    color = Color.White, fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

    }

}