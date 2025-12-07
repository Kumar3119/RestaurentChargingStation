package com.restaurant.chargingstation.model

/**
 * Place represents any result that can be shown to the user.
 * Example: Restaurant, Charging Station, Parking, etc.
 */
data class Place(
    val name: String,
    val type: String, // e.g., "Restaurant" or "Charging"
    val latitude: Double,
    val longitude: Double
)