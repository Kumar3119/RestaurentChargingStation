package com.restaurant.chargingstation.model

/**
 * Location represents the raw GPS data coming from the car.
 *
 * @param latitude  Latitude of the vehicle
 * @param longitude Longitude of the vehicle
 * @param timestamp Time at which the location was recorded
 */
data class Location(
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long
)