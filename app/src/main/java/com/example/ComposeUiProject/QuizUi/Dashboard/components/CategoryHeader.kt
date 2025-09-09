package com.example.ComposeUiProject.QuizUi.Dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.R


@Composable
//@Preview
fun CategoryHeader(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Quiz Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(
                R.color.navy_blue
            )
        )

        Text(
            text = "See all",
            fontSize = 16.sp,
            color = colorResource(
                R.color.orange
            )
        )
    }
}