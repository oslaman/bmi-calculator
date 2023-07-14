package com.oslaman.bmicalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oslaman.bmicalculator.ui.components.LargeDropdownMenu
import com.oslaman.bmicalculator.R
import com.oslaman.bmicalculator.domain.MetricOrImperial

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(
    onResultClick: (String) -> Unit
) {
    val viewModel = hiltViewModel<CalculatorViewModel>()
    val uiState = viewModel.uiState

    val system = rememberSaveable {mutableStateOf(MetricOrImperial.METRIC)}
    val weight = rememberSaveable {mutableStateOf(0.0)}
    val height = rememberSaveable {mutableStateOf(0.0)}

    val chosenSystem =  rememberSaveable {mutableStateOf(-1)}

    Scaffold(
        topBar = {
            LargeTopAppBar(title = { Text("BMI Calculator") })
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier.padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LargeDropdownMenu(
                    label = stringResource(id = R.string.gender),
                    items = MetricOrImperial.values().asList(),
                    onItemSelected = { newItem, _ -> chosenSystem.value = newItem },
                    selectedIndex = chosenSystem.value,
                    selectedItemToString = {value -> value.type}
                )
                Spacer(modifier = Modifier.padding(10.dp))
                TextField(
                    value = weight.value.toString(),
                    onValueChange = { value ->
                        weight.value = value.toDouble()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Next
                    ),
                )
                Spacer(modifier = Modifier.padding(10.dp))
                TextField(
                    value = height.value.toString(),
                    onValueChange = { value ->
                        height.value = value.toDouble()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = { onResultClick(viewModel.calculate(
                    system = MetricOrImperial.values()[chosenSystem.value],
                    weight = weight.value,
                    height = height.value,
                ).toString()) }) {
                    Text(text = stringResource(R.string.calculate))
                }
            }
        }
    }
}