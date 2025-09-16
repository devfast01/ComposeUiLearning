package com.example.ComposeUiProject.TicketApp.Activities.SeatSelect

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.ComposeUiProject.TicketApp.Domain.FlightModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import java.util.*
import com.example.ComposeUiProject.R


enum class SeatStatus {
    AVAILABLE,
    SELECTED,
    UNAVAILABLE,
    EMPTY
}

data class Seat(
    val initialStatus: SeatStatus,
    var name: String,
) {
    var status by mutableStateOf(initialStatus)
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun SeatListScreen(
    flight: FlightModel,
    onBackClick: () -> Unit,
    onConfirm: (FlightModel) -> Unit,
) {
    val context = LocalContext.current

    val seatList = remember { mutableStateListOf<Seat>() }
    val selectedSeatNames = remember { mutableStateListOf<String>() }

    var seatCount by remember { mutableIntStateOf(0) }
    var totalPrice by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(flight) {
        seatList.clear()
        seatList.addAll(generateSeatList(flight))
        seatCount = selectedSeatNames.size
        totalPrice = seatCount * flight.price
    }

    fun updatePriceAndCount() {
        seatCount = selectedSeatNames.size
        totalPrice = seatCount * flight.price
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkPurple2_ticket))
    ) {
        val (topSection, middleSection, bottomSection) = createRefs()

        // Top section
        TopSection(
            modifier = Modifier
                .constrainAs(topSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }, onBackClick
        )

        // middle section
        ConstraintLayout(
            modifier = Modifier
                .padding(top = 100.dp)
                .constrainAs(middleSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            val (airplane, seatGrid) = createRefs()
            Image(
                painter = painterResource(R.drawable.airple_seat),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(airplane) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                modifier = Modifier
                    .padding(top = 240.dp)
                    .padding(horizontal = 64.dp)
                    .constrainAs(seatGrid) {
                        top.linkTo(parent.top)
                        start.linkTo(airplane.start)
                        end.linkTo(airplane.end)
                    }
            ) {
                items(seatList.size) { index ->
                    val seat = seatList[index]
                    SeatItem(
                        seat = seat, onSeatClick = {
                            when (seat.status) {
                                SeatStatus.AVAILABLE -> {
                                    seat.status = SeatStatus.SELECTED
                                    selectedSeatNames.add(seat.name)
                                }

                                SeatStatus.SELECTED -> {
                                    seat.status = SeatStatus.AVAILABLE
                                    selectedSeatNames.remove(seat.name)
                                }

                                else -> {}
                            }
                            updatePriceAndCount()
                        }

                    )
                }
            }
        }
//        selectedSeatNames.remove(seat.name)
        BottomSection(
            seatCount = seatCount,
            selectedItems = selectedSeatNames.joinToString(", "),
            totalPrice = totalPrice,
            onConfirmClick = {
                if (seatCount > 0) {
                    flight.passenger = selectedSeatNames.joinToString(",")
                    flight.price = totalPrice
                    onConfirm(flight)
                } else {
                    Toast.makeText(context, "Please select your seat", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.constrainAs(
                bottomSection
            ) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

private fun generateSeatList(flight: FlightModel): List<Seat> {
    val seatList = mutableListOf<Seat>()
    val numberSeat = flight.numberSeat + (flight.numberSeat / 7) + 1
    val seatAlphabetMap = mapOf(
        0 to "A",
        1 to "B",
        2 to "C",
        4 to "D",
        5 to "E",
        6 to "F",
    )

    var row = 0
    for (i in 0..numberSeat) {
        if (i % 7 == 0) {
            row++
        }
        if (i % 7 == 3) {
            seatList.add(Seat(SeatStatus.EMPTY, row.toString()))
        } else {
            val seatName = seatAlphabetMap[i % 7] + row
            val seatStatus = if (flight.reservedSeats.contains(seatName)) {
                SeatStatus.UNAVAILABLE
            } else {
                SeatStatus.AVAILABLE
            }
            seatList.add(Seat(seatStatus, seatName))
        }
    }
    return seatList
}

@Preview
@Composable
fun SeatListScreenPreview() {
    val flight = FlightModel(
        airlineLogo = "https://www.example.com/logo.png",
        airlineName = "Turkish Airlines",
        arriveTime = "10:00 AM",
        classSeat = "Economy",
        date = "2023-10-26",
        from = "Istanbul",
        fromShort = "IST",
        numberSeat = 150,
        price = 250.0,
        reservedSeats = "A1,B2,C3",
        time = "2h 30m",
        to = "Ankara",
        toShort = "ESB"
    )
    SeatListScreen(flight = flight, onBackClick = {}, onConfirm = {})
}