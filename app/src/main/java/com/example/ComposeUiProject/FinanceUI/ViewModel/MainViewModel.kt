package com.example.ComposeUiProject.ViewModel

import androidx.lifecycle.ViewModel
import com.example.ComposeUiProject.Repository.MainRepository

class MainViewModel(val repository: MainRepository) : ViewModel() {
    constructor() : this(MainRepository())

    fun loadData() = repository.items

    fun loadBudget() = repository.budget
}