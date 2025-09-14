package com.example.ComposeUiProject.TicketApp.Activities.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ComposeUiProject.R


@Composable
@Preview(showBackground = false, showSystemUi = false)
fun TopBar() {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (world, name, profile, notification, title) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.world),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    // Handle click action here
                }
                .constrainAs(world) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(profile) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.bell_icon),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(notification) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "Begli Welliyew",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top)
                start.linkTo(profile.end, 8.dp)
                bottom.linkTo(parent.bottom)
            }
        )

        Text(
            text = "Let's explore the world \n with as!!!",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(profile.bottom)
                bottom.linkTo(parent.bottom)
            }
        )

    }
}