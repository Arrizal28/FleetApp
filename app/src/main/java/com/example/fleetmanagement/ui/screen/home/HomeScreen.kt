package com.example.fleetmanagement.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fleetmanagement.data.model.VehicleState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HomeScreen(
    vehicleState: VehicleState,
    modifier: Modifier = Modifier
) {
    val defaultLocation = LatLng(-6.2088, 106.8456)


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(vehicleState.latitude, vehicleState.longitude),
            15f
        )
    }

    Box(modifier = modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {

            Marker(
                state = MarkerState(
                    position = LatLng(vehicleState.latitude, vehicleState.longitude)
                ),
                title = "Vehicle Location",
                snippet = "Speed: ${String.format("%.1f", vehicleState.speed)} km/h"
            )
        }


        Card(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Vehicle Status",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Speed: ${String.format("%.1f", vehicleState.speed)} km/h")
                    Text(
                        "Engine: ${if (vehicleState.engineStatus) "ON" else "OFF"}",
                        color = if (vehicleState.engineStatus) Color.Green else Color.Red
                    )
                }
                Text(
                    "Doors: ${if (vehicleState.doorStatus) "OPEN" else "CLOSED"}",
                    color = if (vehicleState.doorStatus) Color.Red else Color.Green
                )
            }
        }
    }
}