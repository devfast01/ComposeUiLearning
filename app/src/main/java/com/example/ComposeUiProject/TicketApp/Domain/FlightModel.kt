package com.example.ComposeUiProject.TicketApp.Domain

import java.io.Serializable

data class FlightModel(
    val airlineLogo: String = "",
    val airlineName: String = "",
    val arriveTime: String = "",
    val classSeat: String = "",
    val date: String = "",
    val from: String = "",
    val fromShort: String = "",
    val numberSeat: Int = 0,
    val price: Double = 0.0,
    val reservedSeats: String = "",
    val time: String = "",
    val to: String = "",
    val toShort: String = "",
) : Serializable