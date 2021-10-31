package com.ardroid.rentalio.ui.pages.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardroid.rentalio.domain.VehicleModel
import com.ardroid.rentalio.domain.vehicleList

class HomeViewModel : ViewModel() {

    private val _vehicles = MutableLiveData<List<VehicleModel>>().apply {
        value = vehicleList
    }
    val vehicles: LiveData<List<VehicleModel>> = _vehicles
}