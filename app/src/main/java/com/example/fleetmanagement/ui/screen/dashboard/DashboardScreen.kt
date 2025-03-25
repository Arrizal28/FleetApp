package com.example.fleetmanagement.ui.screen.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fleetmanagement.data.model.VehicleState
import com.example.fleetmanagement.ui.screen.VehicleTrackerViewModel

@Composable
fun DashboardScreen(
    vehicleState: VehicleState,
    viewModel: VehicleTrackerViewModel
) {
    val alerts = remember(vehicleState) {
        viewModel.checkAlerts(vehicleState)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        if (alerts.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("ALERTS:", color = Color.Red, fontWeight = FontWeight.Bold)
                    alerts.forEach { alert ->
                        Text(alert, color = Color.Red)
                    }
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Speed: ${String.format("%.1f", vehicleState.speed)} km/h")
            }
        }


        Card(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Engine Status: ")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (vehicleState.engineStatus) "ON" else "OFF",
                    color = if (vehicleState.engineStatus) Color.Green else Color.Red
                )
            }
        }


        Card(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Door Status: ")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (vehicleState.doorStatus) "OPEN" else "CLOSED",
                    color = if (vehicleState.doorStatus) Color.Red else Color.Green
                )
            }
        }
    }
}