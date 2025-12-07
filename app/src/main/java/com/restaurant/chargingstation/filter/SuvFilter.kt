package com.restaurant.chargingstation.filter

import com.restaurant.chargingstation.model.Location

/**
 * SUV-specific location refinement.
 * Applies rough-terrain compensation.
 */
class SuvFilter : LocationFilter {
    override fun applyFilter(rawLocation: Location): Location {
// Slightly more aggressive offset for rough terrain
        val lat = rawLocation.latitude + 0.00035
        val lon = rawLocation.longitude + 0.00035
        return rawLocation.copy(latitude = lat, longitude = lon)
    }
}