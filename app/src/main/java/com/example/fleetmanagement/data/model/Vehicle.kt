package com.example.fleetmanagement.data.model

data class VehicleState(
    val latitude: Double = -6.2088,
    val longitude: Double = 106.8456,
    val speed: Double = 0.0,
    val engineStatus: Boolean = false,
    val doorStatus: Boolean = false
)