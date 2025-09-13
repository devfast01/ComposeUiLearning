package com.example.ComposeUiProject.HomeApp.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ComposeUiProject.HomeApp.feature.components.HomeTopBar
import com.example.ComposeUiProject.R
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeProfileScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.lightGreyHome)),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item { HomeTopBar(onBackClick = { navController.navigateUp() }) }
    }

}

@Preview
@Composable
fun HomeProfileScreenPreview() {
    val navController = rememberNavController()
    HomeProfileScreen(navController)
}
