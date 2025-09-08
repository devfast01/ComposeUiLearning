package com.example.ComposeUiProject.Activities.DashboardAcivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ComposeUiProject.Activities.DashboardAcivity.components.ActionButtonRow
import com.example.ComposeUiProject.Activities.DashboardAcivity.components.BottomNavigationBar
import com.example.ComposeUiProject.Activities.DashboardAcivity.components.CardSection
import com.example.ComposeUiProject.Activities.DashboardAcivity.components.ExpenseItem
import com.example.ComposeUiProject.Activities.DashboardAcivity.components.HeaderSection
import com.example.ComposeUiProject.Domain.ExpenseDomain
import com.example.ComposeUiProject.R

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    val expenses = listOf(
        ExpenseDomain(
            title = "Restaurant",
            price = 573.2,
            pic = "resturant",
            time = "5 Cent 2025 10:25"
        ),
        ExpenseDomain(
            title = "McDonald",
            price = 89.2,
            pic = "mcdonald",
            time = "6 Cent 2025 11:55"
        ),
        ExpenseDomain(title = "Cinema", price = 25.2, pic = "cinema", time = "7 Cent 2025 12:24"),
        ExpenseDomain(
            title = "Restaurant",
            price = 73.2,
            pic = "resturant",
            time = "8 Cent 2025 13:35"
        )
    )

    MainScreen(expenses = expenses)
}

@Composable
fun MainScreen(
    onCardClick: () -> Unit = {},
    expenses: List<ExpenseDomain>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                HeaderSection()
            }
            item { CardSection(onClick = onCardClick) }
            item { ActionButtonRow() }
            items(items = expenses) { item -> ExpenseItem(item) }
        }

        BottomNavigationBar(modifier = Modifier
            .align(Alignment.BottomCenter)
            .height(80.dp), onItemSelected = {itemId ->
                if (itemId == R.id.wallet){

                }
        })
    }

}