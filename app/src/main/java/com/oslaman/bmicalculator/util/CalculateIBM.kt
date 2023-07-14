package com.oslaman.bmicalculator.util

import com.oslaman.bmicalculator.domain.MetricOrImperial
import kotlin.math.pow
import kotlin.math.sqrt

fun calculateIBM(system: MetricOrImperial, weight: Double, height: Double): Double {
    return when (system) {
        MetricOrImperial.METRIC -> weight/height.pow(2)
        MetricOrImperial.IMPERIAL -> (weight * 703)/sqrt(height)
        else -> weight/height.pow(2)
    }

}