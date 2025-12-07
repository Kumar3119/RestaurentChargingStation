package com.restaurant.chargingstation.repository

import com.restaurant.chargingstation.model.Location

/**
 * LocationRepository defines how filtered locations are stored.
 *
 * Current implementation is only in-memory because:
 * - Data is required only while app is running
 * - No persistent database is required
 */
interface LocationRepository {
    fun save(location: Location)
    fun getAll(): List<Location>
}