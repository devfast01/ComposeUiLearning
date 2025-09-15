package com.example.ComposeUiProject.TicketApp.ViewModel

import androidx.lifecycle.LiveData
import com.example.ComposeUiProject.TicketApp.Domain.LocationModel
import com.example.ComposeUiProject.TicketApp.Repository.TickerRepository

class TicketViewModel {

    private val repository= TickerRepository()

    fun loadLocation(): LiveData<MutableList<LocationModel>> {
        return repository.loadLocation()
    }
}