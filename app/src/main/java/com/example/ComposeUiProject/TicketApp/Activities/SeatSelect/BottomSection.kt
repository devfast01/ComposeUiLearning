package com.example.ComposeUiProject.TicketApp.Activities.SeatSelect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.TicketApp.Activities.Splash.GradientButton

@Composable
fun BottomSection(
    seatCount: Int,
    selectedItems: String,
    totalPrice: Double,
    onConfirmClick: () -> Unit,
    modifier: Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(color = colorResource(R.color.darkPurple_ticket))
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LegendItem(text = "Available", color = colorResource(R.color.green_ticket))
            LegendItem(text = "Selected", color = colorResource(R.color.orange_ticket))
            LegendItem(text = "Unavailable", color = colorResource(R.color.grey_ticket))
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "$seatCount selected Seats",
                    color = colorResource(R.color.white),
                    fontWeight = FontWeight.Bold, fontSize = 14.sp
                )

                Text(
                    text = if (selectedItems.isBlank()) "-" else selectedItems,
                    color = colorResource(R.color.white),
                    fontWeight = FontWeight.Bold, fontSize = 14.sp
                )
            }
            Text(
                text = "$${String.format("%.2f", totalPrice)}",
                color = colorResource(R.color.orange_ticket),
                fontWeight = FontWeight.SemiBold, fontSize = 25.sp
            )
        }
        GradientButton(onClick = onConfirmClick, "Confirm Seats", padding = 16)
    }

}