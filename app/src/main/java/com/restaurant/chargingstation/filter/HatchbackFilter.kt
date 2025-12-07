package com.restaurant.chargingstation.filter

import com.restaurant.chargingstation.model.Location

/**
 * HATCHBACK-specific location refinement.
 * Applies rough-terrain compensation.
 */
class HatchbackFilter : LocationFilter {
    override fun applyFilter(rawLocation: Location): Location {
// Simple smoothing (example). Real algorithm provided by other team.
        val lat = rawLocation.latitude + 0.00005
        val lon = rawLocation.longitude + 0.00005
        return rawLocation.copy(latitude = lat, longitude = lon)
    }
}