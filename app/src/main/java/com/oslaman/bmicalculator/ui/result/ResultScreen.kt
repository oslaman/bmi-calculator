package com.oslaman.bmicalculator.ui.result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen() {
    val viewModel = hiltViewModel<ResultViewModel>()
    val uiState = viewModel.uiState
    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Text(text = uiState.result.result, style = MaterialTheme.typography.displayLarge)
        }
    }
}