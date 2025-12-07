package com.restaurant.chargingstation.filter

import com.restaurant.chargingstation.model.Location

/**
 * Sedan-specific GPS refinement.
 * More conservative correction.
 */
class SedanFilter : LocationFilter {
    override fun applyFilter(rawLocation: Location): Location {
// Simple smoothing (example). Real algorithm provided by other team.
        val lat = rawLocation.latitude + 0.00005
        val lon = rawLocation.longitude + 0.00005
        return rawLocation.copy(latitude = lat, longitude = lon)
    }
}