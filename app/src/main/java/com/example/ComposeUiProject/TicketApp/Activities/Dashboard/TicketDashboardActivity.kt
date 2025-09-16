package com.example.ComposeUiProject.TicketApp.Activities.Dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ComposeUiProject.R
import com.example.ComposeUiProject.TicketApp.Activities.SearchResult.SearchActivity
import com.example.ComposeUiProject.TicketApp.Activities.Splash.GradientButton
import com.example.ComposeUiProject.TicketApp.Activities.Splash.StatusTopBarColor
import com.example.ComposeUiProject.TicketApp.Domain.LocationModel
import com.example.ComposeUiProject.TicketApp.ViewModel.TicketViewModel
import kotlin.jvm.java

@Suppress("DEPRECATION")
class TicketDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_quiz)
        setContent {
            TicketMainScreen()
        }
    }
}

@Composable
@Preview
fun TicketMainScreen() {
    val locations = remember { mutableListOf<LocationModel>() }
    var showLocationLoading by remember { mutableStateOf(true) }
    val viewModel: TicketViewModel = viewModel<TicketViewModel>()

    var from: String = ""
    var to: String = ""
    var classes: String = ""

    var adultPassenger: String = ""
    var childPassenger: String = ""
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loadLocation().observeForever { result ->
            locations.clear()
            locations.addAll(result)
            showLocationLoading = false
        }
    }

    Scaffold(
        bottomBar = { MyBottomBar() },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.darkPurple2_ticket))
                .padding(paddingValues)
        ) {
            item { TopBar() }
            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 32.dp, vertical = 16.dp)
                        .background(
                            colorResource(R.color.darkPurple_ticket),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp)
                ) {
                    YellowTitle("From")
                    val locationNames: List<String> = locations.map { it.Name }

                    DropDownList(
                        items = locationNames,
                        loadingIcon = painterResource(R.drawable.from_ic),
                        hint = "Select origin",
                        showLocationLoading = showLocationLoading,
                    ) { selectedItem ->
                        from = selectedItem
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    YellowTitle("To")
                    DropDownList(
                        items = locationNames,
                        loadingIcon = painterResource(R.drawable.to_ic),
                        hint = "Select Destination",
                        showLocationLoading = showLocationLoading,
                    ) { selectedItem ->
                        to = selectedItem
                    }

                    // Passenger Counter
                    Spacer(modifier = Modifier.height(16.dp))
                    YellowTitle("Passengers")
                    Row(modifier = Modifier.fillMaxWidth()) {
                        PassengerCounter(
                            title = "Adult",
                            modifier = Modifier.weight(1f),
                            onItemSelected = { adultPassenger = it })
                        Spacer(modifier = Modifier.width(16.dp))
                        PassengerCounter(
                            title = "Child",
                            modifier = Modifier.weight(1f),
                            onItemSelected = { childPassenger = it })
                    }

                    // calendar Picker
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        YellowTitle("Departure date", modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(16.dp))
                        YellowTitle("Return date", modifier = Modifier.weight(1f))
                    }
                    DatePickerScreen(Modifier.weight(1f))

                    Spacer(modifier = Modifier.height(16.dp))
                    YellowTitle("class")
                    val classItems = listOf("Business class", "First class", "Economy class")
                    DropDownList(
                        items = classItems,
                        loadingIcon = painterResource(R.drawable.seat_black_ic),
                        hint = "Select class",
                        showLocationLoading = false,
                    ) { selectedItem ->
                        classes = selectedItem
                    }

                }
            }

            item {
                // Search Button
                GradientButton(onClick = {
                    val intent = Intent(context, SearchActivity::class.java).apply {
                        putExtra("from", from)
                        putExtra("to", to)
                        putExtra("numPassengers", adultPassenger + childPassenger)
                    }
                    context.startActivity(intent)
                }, text = "Search", padding = 16)
            }
        }

    }
}

@Composable
fun YellowTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = colorResource(R.color.orange_ticket),
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}