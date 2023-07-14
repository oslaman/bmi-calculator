package com.oslaman.bmicalculator.ui.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.oslaman.bmicalculator.domain.MetricOrImperial
import com.oslaman.bmicalculator.util.calculateIBM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(CalculatorUiState())

    fun calculate(system: MetricOrImperial, weight: Double, height: Double): Double {
        return calculateIBM(system = system, weight = weight, height = height)
    }
}