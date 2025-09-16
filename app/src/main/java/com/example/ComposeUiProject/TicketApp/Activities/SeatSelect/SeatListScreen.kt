package com.example.ComposeUiProject.TicketApp.Activities.SeatSelect

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.ComposeUiProject.TicketApp.Domain.FlightModel
import androidx.compose.runtime.*
import java.util.*
import com.example.ComposeUiProject.R


enum class SeatStatus {
    AVAILABLE,
    SELECTED,
    UNAVAILABLE,
    EMPTY
}

data class Seat(
    var status: SeatStatus,
    var name: String,
)

@SuppressLint("AutoboxingStateCreation")
@Composable
fun SeatListScreen(
    flight: FlightModel,
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    val context = LocalContext.current

    val seatList = remember { mutableListOf<Seat>() }
    val selectedSeatNames = remember { mutableStateListOf<String>() }

    var seatCount by remember { mutableIntStateOf(0) }
    var totalPrice by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(flight) {
        seatList.clear()
        seatList.addAll(generateSeatList(flight))
        seatCount = selectedSeatNames.size
        totalPrice = seatCount * flight.price

    }
}

private fun generateSeatList(flight: FlightModel): List<Seat> {
    val seatList = mutableListOf<Seat>()
    val numberSeat = flight.numberSeat + (flight.numberSeat / 7) + 1
    val seatAlphabetMap = mapOf(
        0 to "A",
        1 to "B",
        2 to "C",
        3 to "D",
        4 to "E",
        5 to "F",
        6 to "G",
    )

    var row = 0
    for (i in 1..numberSeat) {
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
