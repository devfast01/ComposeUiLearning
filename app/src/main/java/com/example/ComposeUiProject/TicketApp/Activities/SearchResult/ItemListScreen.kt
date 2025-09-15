package com.example.ComposeUiProject.TicketApp.Activities.SearchResult


import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.example.ComposeUiProject.TicketApp.ViewModel.TicketViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ComposeUiProject.R

@Composable
fun ItemListScreen(
    from: String,
    to: String,
    onBackClick: () -> Unit,
) {
    // Use the generic viewModel<T>() function with your specific ViewModel class
    val viewModel: TicketViewModel = viewModel<TicketViewModel>()
    val items by viewModel.loadFiltered(from, to).observeAsState(emptyList())
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(from, to) {
        viewModel.loadFiltered(from, to)
    }
    LaunchedEffect(items) {
        isLoading = items.isEmpty()
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkPurple2_ticket))
            .padding(top = 45.dp, start = 16.dp, end = 16.dp)
    ) {
        val (backBtn, headerTitle, worldImg) = createRefs()
        Image(
            painter = painterResource(R.drawable.back_home),
            contentDescription = null,
            modifier = Modifier
                .clickable { onBackClick() }
                .constrainAs(backBtn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = "Search Results",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .constrainAs(headerTitle) {
                    top.linkTo(backBtn.top)
                    start.linkTo(backBtn.end, margin = 8.dp)
                    bottom.linkTo(backBtn.bottom)
                },
        )
        Image(
            painter = painterResource(R.drawable.world),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(worldImg) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
    }

    // show list
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .padding(top = 100.dp)
        ) {
            itemsIndexed(items) { index, item ->
                FlightItem(item = item, index = index)
            }
        }
    }

}