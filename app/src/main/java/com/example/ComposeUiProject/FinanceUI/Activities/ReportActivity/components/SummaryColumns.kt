package com.example.ComposeUiProject.Activities.ReportActivity.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.R


@Preview
@Composable
fun SummaryColumnsPreview() {
    SummaryColumns()
}


@Composable
fun SummaryColumns(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SummaryColumn(
            title = "Total Balance",
            value = "$3,452.23",
            percent = "+25%",
            percentColor = Color(0xff2d9738),
            modifier = Modifier.weight(1f)
        )

        VerticalDivider()

        SummaryColumn(
            title = "Income",
            value = "$165.21",
            percent = "-10%",
            percentColor = Color(0xffef2642),
            modifier = Modifier.weight(1f)
        )

        VerticalDivider()

        SummaryColumn(
            title = "Saving",
            value = "$1,542.22",
            percent = "+16%",
            percentColor = Color(0xff2d9738),
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun SummaryColumn(
    title: String,
    value: String,
    percent: String,
    percentColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
        Text(
            text = title,
            fontSize = 12.sp,
            color = colorResource(R.color.darkBlue)
        )

        Text(
            text = value, color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 2.dp)
        )

        Text(
            text = percent, fontSize = 13.sp,
            color = percentColor
        )

    }

}