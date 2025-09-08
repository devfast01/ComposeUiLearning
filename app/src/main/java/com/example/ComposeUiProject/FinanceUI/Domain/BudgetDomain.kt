package com.example.ComposeUiProject.Domain

import java.io.Serializable


data class BudgetDomain(
    val title: String,
    val price: Double,
    val percent: Double,
) : Serializable
