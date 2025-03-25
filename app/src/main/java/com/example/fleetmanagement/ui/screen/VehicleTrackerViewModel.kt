package com.example.fleetmanagement.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fleetmanagement.data.model.VehicleState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class VehicleTrackerViewModel @Inject constructor() : ViewModel() {
    private val _vehicleState = MutableStateFlow(VehicleState())
    val vehicleState: StateFlow<VehicleState> = _vehicleState.asStateFlow()

    private val routeCoordinates = listOf(
        Pair(-6.2088, 106.8456),
        Pair(-6.2100, 106.8470),
        Pair(-6.2115, 106.8485),
        Pair(-6.2130, 106.8500)
    )
    private var currentRouteIndex = 0

    init {
        startVehicleDataSimulation()
    }

    private fun startVehicleDataSimulation() {
        viewModelScope.launch {
            while (true) {
                updateVehicleState()
                delay(3000)
            }
        }
    }

    private fun updateVehicleState() {
        // Simulate route movement
        if (currentRouteIndex < routeCoordinates.size - 1) {
            currentRouteIndex++
        } else {
            currentRouteIndex = 0
        }

        val (lat, lon) = routeCoordinates[currentRouteIndex]

        _vehicleState.update { currentState ->
            currentState.copy(
                latitude = lat,
                longitude = lon,
                speed = Random.Default.nextDouble(0.0, 100.0),
                engineStatus = Random.Default.nextBoolean(),
                doorStatus = Random.Default.nextBoolean()
            )
        }
    }

    fun checkAlerts(state: VehicleState): List<String> {
        val alerts = mutableListOf<String>()

        if (state.speed > 80) {
            alerts.add("SPEED ALERT: Exceeding 80 km/h!")
        }

        if (state.doorStatus && state.speed > 0) {
            alerts.add("ALERT: Door Open While Moving!")
        }

        return alerts
    }
}