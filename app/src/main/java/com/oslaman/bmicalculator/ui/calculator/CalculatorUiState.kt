package com.oslaman.bmicalculator.ui.calculator

import com.oslaman.bmicalculator.domain.MetricOrImperial
import com.oslaman.bmicalculator.domain.Person

data class CalculatorUiState(
    val person: Person = Person(
        system = MetricOrImperial.METRIC,
        weight = 88.5,
        height = 1.87
    )
)