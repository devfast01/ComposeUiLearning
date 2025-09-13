package com.example.ComposeUiProject.HomeApp.feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ComposeUiProject.HomeApp.core.model.PropertyHome
import com.example.ComposeUiProject.R


@Composable
fun PropertyCard(item: PropertyHome) {

    val white = colorResource(R.color.white)
    val blue = colorResource(R.color.blue)
    val black = colorResource(R.color.black)
    val grey = colorResource(R.color.grey)

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(320.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(white)
    ) { }
}

@Preview
@Composable
fun PropertyCardPreview() {
    val item = PropertyHome(
        type = "Apartment",
        title = "Modern Apartment",
        address = "123 Main St, Anytown, USA",
        pickPath = "apartment.jpg",
        price = 1200,
        bed = 2,
        bath = 2,
        size = 1000,
        isGarage = true,
        score = 4.5,
        description = "A beautiful and modern apartment in the heart of the city."
    )
    PropertyCard(item)
}
