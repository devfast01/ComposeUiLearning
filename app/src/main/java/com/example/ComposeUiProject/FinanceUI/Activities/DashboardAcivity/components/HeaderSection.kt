package com.example.ComposeUiProject.Activities.DashboardAcivity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.R


@Composable
@Preview
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 48.dp, end = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(
                text = "Hello Begli Welli",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.darkBlue)
            )

            Text(
                text = "iot123tech@gmai.com",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.darkBlue)
            )

        }

        Image(
            painter = painterResource(R.drawable.men),
            contentDescription = "men image",
            modifier = Modifier.size(50.dp)
        )
        
    }
}