package com.restaurant.chargingstation.service

import com.restaurant.chargingstation.model.Location
import com.restaurant.chargingstation.model.Place
/**
 * PlaceService is responsible for fetching places based on location.
 *
 * In real production:
 * - This would call a backend REST API
 *
 * In this assignment:
 * - We return mock data as third-party libs are not allowed
 */
class PlaceService {
    // Mocked implementation — replace with real API client when available.
    fun fetchNearbyPlaces(location: Location): List<Place> {
        val places = mutableListOf<Place>()
        places.add(
            Place(
                name = "Green Restaurant",
                type = "Restaurant",
                latitude = location.latitude + 0.001,
                longitude = location.longitude + 0.001
            )
        )
        places.add(
            Place(
                name = "EV Fast Charge",
                type = "Charging",
                latitude = location.latitude + 0.002,
                longitude = location.longitude + 0.002
            )
        )
        return places
    }
}