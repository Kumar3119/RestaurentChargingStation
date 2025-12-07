package com.restaurant.chargingstation.filter

import com.restaurant.chargingstation.model.Location

/**
 * LocationFilter transforms raw GPS location data into a refined location.
 * Each car model provides its own transformation logic.
 */
interface LocationFilter {
    fun applyFilter(rawLocation: Location): Location
}

