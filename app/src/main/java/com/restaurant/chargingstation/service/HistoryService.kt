package com.restaurant.chargingstation.service

import com.restaurant.chargingstation.model.Location
import com.restaurant.chargingstation.repository.InMemoryLocationRepository
/**
 * HistoryService provides read-only access to location history.
 *
 * This separates:
 * - Write responsibility → LocationService
 * - Read responsibility → HistoryService
 *
 * This follows the Single Responsibility Principle (SRP).
 */
class HistoryService(private val repo: InMemoryLocationRepository) {
    fun getLocationHistory(): List<Location> = repo.getAll()
}