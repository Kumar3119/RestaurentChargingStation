package com.restaurant.chargingstation.model

/**
 * CarModel represents the different supported car types.
 *
 * Implemented as a sealed class instead of enum so that:
 * - The hierarchy is restricted at compile time
 * - New car types can have custom behavior in future
 * - Type safety is guaranteed in 'when' expressions
 */
sealed class CarModel {
    object Sedan : CarModel()
    object Suv : CarModel()
    object Hatchback : CarModel()


    // This allows future dynamic models if needed
    data class Custom(val modelName: String) : CarModel()
}