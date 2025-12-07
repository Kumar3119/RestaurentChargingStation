package com.restaurant.chargingstation.factory

import com.restaurant.chargingstation.filter.HatchbackFilter
import com.restaurant.chargingstation.filter.LocationFilter
import com.restaurant.chargingstation.filter.SedanFilter
import com.restaurant.chargingstation.filter.SuvFilter
import com.restaurant.chargingstation.model.CarModel

/**
 * FilterFactory decides which filtering algorithm
 * should be applied based on the selected CarModel.
 *
 * This follows the Factory Design Pattern.
 */
object FilterFactory {
    fun getFilter(model: CarModel): LocationFilter = when (model) {
        is CarModel.Suv -> SuvFilter()
        is CarModel.Sedan -> SedanFilter()
        is CarModel.Hatchback -> HatchbackFilter()
        is CarModel.Custom -> SedanFilter() // default behavior for unknown models
    }
}