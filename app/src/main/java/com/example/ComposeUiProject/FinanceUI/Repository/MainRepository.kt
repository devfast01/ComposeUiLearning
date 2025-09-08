package com.example.ComposeUiProject.Repository

import com.example.ComposeUiProject.Domain.BudgetDomain
import com.example.ComposeUiProject.Domain.ExpenseDomain

class MainRepository() {
    val items = mutableListOf(
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

    val budget = mutableListOf(
        BudgetDomain("Home Load", 1200.3, 80.0),
        BudgetDomain("Subscription", 500.3, 50.0),
        BudgetDomain("Car Loan", 1200.3, 30.0)
    )
}