package com.restaurant.chargingstation.service

import com.restaurant.chargingstation.filter.LocationFilter
import com.restaurant.chargingstation.model.Location
import com.restaurant.chargingstation.model.Place
import com.restaurant.chargingstation.repository.InMemoryLocationRepository
import com.restaurant.chargingstation.repository.LocationRepository

/**
 * LocationService handles processing of raw location data.
 *
 * Responsibilities:
 * - Apply car-specific filtering
 * - Save valid locations to repository
 * - Fetch nearby places from PlaceService
 */
class LocationService(
    private val filter: LocationFilter,
    private val placeService: PlaceService,
    private val repository: LocationRepository
) {

    fun processLocation(rawLocation: Location): List<Place> {
        // Apply transformation instead of boolean check
        val refinedLocation = filter.applyFilter(rawLocation)

        // Store transformed data
        repository.save(refinedLocation)

        // Fetch places using refined location
        return placeService.fetchNearbyPlaces(refinedLocation)
    }
}