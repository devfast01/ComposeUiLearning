package com.example.ComposeUiProject.TicketApp.Activities.TicketDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.ComposeUiProject.TicketApp.Domain.FlightModel
import com.example.ComposeUiProject.R

@Composable
fun TicketDetailContent(
    flight: FlightModel,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .padding(24.dp)
            .background(
                color = colorResource(R.color.lightPurple_ticket),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            val (logo, arrivalTxt, lineImg, fromTxt, fromShortTxt, toTxt, toShortTxt) = createRefs()

            AsyncImage(
                model = flight.airlineLogo,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp, 50.dp)
                    .constrainAs(logo) {
                        top.linkTo(parent.top, 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }, contentScale = ContentScale.Fit
            )

            Text(
                text = flight.arriveTime,
                color = colorResource(R.color.darkPurple2_ticket),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .constrainAs(arrivalTxt) {
                        top.linkTo(logo.bottom, 8.dp)
                        start.linkTo(logo.start)
                        end.linkTo(logo.end)
                    }
            )
            Image(
                painter = painterResource(R.drawable.line_airple_blue),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(lineImg) {
                        top.linkTo(arrivalTxt.bottom, 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Text(
                text = "from",
                color = colorResource(R.color.black),
                fontSize = 14.sp,
                modifier = Modifier
                    .constrainAs(fromTxt) {
                        top.linkTo(arrivalTxt.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(lineImg.start)
                    }
            )

            Text(
                text = flight.fromShort,
                color = colorResource(R.color.black),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(fromShortTxt) {
                        top.linkTo(fromTxt.bottom, 8.dp)
                        start.linkTo(fromTxt.start)
                        end.linkTo(fromTxt.end)
                        bottom.linkTo(lineImg.bottom)
                    }
            )

            Text(
                text = "to",
                color = colorResource(R.color.black),
                fontSize = 14.sp,
                modifier = Modifier
                    .constrainAs(toTxt) {
                        top.linkTo(arrivalTxt.bottom)
                        start.linkTo(lineImg.end)
                        end.linkTo(parent.end)
                    }
            )

            Text(
                text = flight.toShort,
                color = colorResource(R.color.black),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(toShortTxt) {
                        top.linkTo(toTxt.bottom, 8.dp)
                        start.linkTo(toTxt.start)
                        end.linkTo(toTxt.end)
                        bottom.linkTo(lineImg.bottom)
                    }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Text(text = "From", color = Color.Black)
                Text(text = flight.from, color = Color.Black, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Data", color = Color.Black)
                Text(text = flight.date, color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Text(text = "To", color = Color.Black)
                Text(text = flight.to, color = Color.Black, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Time", color = Color.Black)
                Text(text = flight.time, color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }

        Image(
            painter = painterResource(R.drawable.dash_line),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Text(text = "Class", color = Color.Black)
                Text(text = flight.classSeat, color = Color.Black, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Seats", color = Color.Black)
                Text(text = flight.passenger, color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Text(text = "Airlines", color = Color.Black)
                Text(text = flight.airlineName, color = Color.Black, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Price", color = Color.Black)
                Text(
                    text = "$${String.format("%.2f", flight.price)}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(R.drawable.qrcode),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 8.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        Image(
            painter = painterResource(R.drawable.dash_line),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Image(
            painter = painterResource(R.drawable.barcode),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentScale = ContentScale.FillWidth
        )

    }
}

@Preview
@Composable
fun TicketDetailScreenPreview() {
    val flight = FlightModel(
        airlineLogo = "https://www.gstatic.com/webp/gallery/1.jpg",
        airlineName = "Airline Name",
        arriveTime = "10:00 AM",
        classSeat = "Economy",
        date = "2023-10-26",
        from = "City A",
        fromShort = "CTA",
        numberSeat = 1,
        price = 100.0,
        reservedSeats = "1A",
        time = "2 hours",
        to = "City B",
        toShort = "CTB",
        passenger = "John Doe"
    )
    TicketDetailContent(flight = flight, modifier = Modifier)
}
