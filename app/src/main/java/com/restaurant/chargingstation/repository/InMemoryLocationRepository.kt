package com.restaurant.chargingstation.repository

import com.restaurant.chargingstation.model.Location
import java.util.concurrent.CopyOnWriteArrayList

/**
 * InMemoryLocationRepository stores location data only in RAM.
 *
 * This satisfies the requirement:
 * "The app only needs to store data while it is running."
 */
class InMemoryLocationRepository : LocationRepository {
    private val history = CopyOnWriteArrayList<Location>()


    override fun save(location: Location) {
        history.add(location)
    }


    override fun getAll(): List<Location> = history.toList()


    fun clear() = history.clear()
}