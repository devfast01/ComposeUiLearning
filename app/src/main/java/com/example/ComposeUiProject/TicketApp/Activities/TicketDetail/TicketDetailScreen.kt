package com.example.ComposeUiProject.TicketApp.Activities.TicketDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.res.colorResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.TicketApp.Activities.SeatSelect.TicketDetailHeader
import com.example.ComposeUiProject.TicketApp.Activities.Splash.GradientButton
import com.example.ComposeUiProject.TicketApp.Domain.FlightModel

@Composable
fun TicketDetailScreen(
    flight: FlightModel,
    onBackClick: () -> Unit,
    onDownloadTicketClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.darkPurple2_ticket))
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(colorResource(R.color.darkPurple2_ticket))
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.darkPurple2_ticket))
            ) {
                val (topSection, ticketDetail) = createRefs()

                TicketDetailHeader(onBackClick = onBackClick, Modifier.constrainAs(topSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            }
            GradientButton(onClick = {}, text = "Download Ticket", 16)
        }
    }
}