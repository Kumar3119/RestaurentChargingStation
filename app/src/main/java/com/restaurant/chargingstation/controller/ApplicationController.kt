package com.restaurant.chargingstation.controller

import android.util.Log
import com.restaurant.chargingstation.factory.FilterFactory
import com.restaurant.chargingstation.model.CarModel
import com.restaurant.chargingstation.model.Location
import com.restaurant.chargingstation.repository.InMemoryLocationRepository
import com.restaurant.chargingstation.service.HistoryService
import com.restaurant.chargingstation.service.LocationService
import com.restaurant.chargingstation.service.PlaceService

/**
 * ApplicationController acts as the central coordinator of the application.
 *
 * Responsibilities:
 * - Decides which CarModel is being used
 * - Selects the correct filtering algorithm via FilterFactory
 * - Wires together all services and repository
 * - Starts processing of incoming location data
 * - Acts as the single control point for application flow
 *
 * This class does NOT:
 * - Store data
 * - Apply filtering itself
 * - Fetch places from API directly
 *
 * It only coordinates the flow.
 */
object ApplicationController {

    fun start() {
        val carModel = CarModel.Suv

        val filter = FilterFactory.getFilter(carModel)
        val repo = InMemoryLocationRepository()
        val placeService = PlaceService()
        val locationService = LocationService(filter, placeService, repo)
        val historyService = HistoryService(repo)

        // Simulate a stream of raw locations
        val rawLocations = listOf(
            Location(22.7196, 75.8577, System.currentTimeMillis()),
            Location(22.7200, 75.8580, System.currentTimeMillis() + 1000),
            Location(22.7205, 75.8585, System.currentTimeMillis() + 2000)
        )


        println("Processing locations for car model: $carModel")
        Log.i("RestaurantApplication","Processing locations for car model: $carModel")
        for (raw in rawLocations) {
            val places = locationService.processLocation(raw)
            println("Raw: $raw -> Filtered saved. Nearby places:")
            Log.i("RestaurantApplication","Raw: $raw -> Filtered saved. Nearby places:")
            places.forEach {
                println(" - ${it.name} [${it.type}] @ ${it.latitude},${it.longitude}")
                Log.i("RestaurantApplication"," - ${it.name} [${it.type}] @ ${it.latitude},${it.longitude}")
            }
        }


        println("\n--- History ---")
        Log.i("RestaurantApplication","\n--- History ---")
        historyService.getLocationHistory().forEachIndexed { idx, loc ->
            println("$idx: $loc")
            Log.i("RestaurantApplication","$idx: $loc")
        }
}
}