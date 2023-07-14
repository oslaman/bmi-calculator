package com.oslaman.bmicalculator.domain

data class Person(
    val system: MetricOrImperial,
    val weight: Double,
    val height: Double,
)

enum class MetricOrImperial(val type: String) {
    METRIC("kg/m"),
    IMPERIAL("lb/in")
}