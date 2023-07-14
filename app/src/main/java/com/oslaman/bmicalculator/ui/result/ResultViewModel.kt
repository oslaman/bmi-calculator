package com.oslaman.bmicalculator.ui.result

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oslaman.bmicalculator.domain.Result
import com.oslaman.bmicalculator.ui.Argument
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val result: String? = savedStateHandle[Argument.RESULT]

    var uiState by mutableStateOf(ResultUiState())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                result?.let { Result(result = it) }?.let {
                    uiState.copy(
                        result = it
                    )
                }
            }
        }

    }
}