package com.example.ComposeUiProject.TicketApp.Activities.Dashboard


import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import java.text.SimpleDateFormat
import java.util.Calendar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.*
import com.example.ComposeUiProject.R

@Composable
fun DatePickerScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val dateFormat = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }

    val departureCalendar = remember { Calendar.getInstance() }
    val returnCalendar = remember { Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 1) } }

    var departureDate by remember { mutableStateOf(dateFormat.format(departureCalendar.time)) }
    var returnDate by remember { mutableStateOf(dateFormat.format(returnCalendar.time)) }

    Row {
        DatePickerItem(
            modifier = modifier,
            dateText = departureDate,
            onDateSelected = { selectedDate ->
                departureDate = selectedDate
            },
            dateFormat = dateFormat,
            calendar = departureCalendar,
            context = context
        )
        Spacer(modifier = Modifier.width(16.dp))
        DatePickerItem(
            modifier = modifier,
            dateText = returnDate,
            onDateSelected = { selectedDate ->
                returnDate = selectedDate
            },
            dateFormat = dateFormat,
            calendar = departureCalendar,
            context = context
        )
    }
}

@Composable
fun DatePickerItem(
    modifier: Modifier = Modifier,
    dateText: String,
    onDateSelected: (String) -> Unit,
    dateFormat: SimpleDateFormat,
    calendar: Calendar,
    context: Context,
) {
    Row(
        modifier = modifier
            .height(68.dp)
            .padding(top = 8.dp)
            .background(
                color = colorResource(R.color.lightPurple_ticket),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                showDatePickerDialog(context, calendar, dateFormat, onDateSelected)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.calendar_ic),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp)
        )

        Text(
            text = dateText,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
    }
}

fun showDatePickerDialog(
    context: Context,
    calendar: Calendar,
    dateFormat: SimpleDateFormat,
    onDateSelected: (String) -> Unit,
) {
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            calendar.set(selectedYear, selectedMonth, selectedDay)
            val formattedDate = dateFormat.format(calendar.time)
            onDateSelected(formattedDate)
        },
        year,
        month,
        day
    ).show()
}