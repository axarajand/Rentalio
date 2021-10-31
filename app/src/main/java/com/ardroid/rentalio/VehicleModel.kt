package com.ardroid.rentalio

data class VehicleModel(
    val image: Int,
    val name: String
)

val vehicleList = listOf(
    VehicleModel(R.drawable.city, "CITY"),
    VehicleModel(R.drawable.suv, "SUV"),
    VehicleModel(R.drawable.mpv, "MPV"),
    VehicleModel(R.drawable.jeep, "JEEP"),
    VehicleModel(R.drawable.jeep, "BUS"),
    VehicleModel(R.drawable.mpv, "BOX"),
    VehicleModel(R.drawable.suv, "VAN"),
    VehicleModel(R.drawable.city, "SPORT"),
    VehicleModel(R.drawable.moped, "SPEC"),
    VehicleModel(R.drawable.scooter, "CUSTOM RIDE"),
    VehicleModel(R.drawable.classic, "YATCH"),
    VehicleModel(R.drawable.trail, "JET")
)