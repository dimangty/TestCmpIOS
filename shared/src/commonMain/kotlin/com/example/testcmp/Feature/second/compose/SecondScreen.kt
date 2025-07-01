package com.example.testcmp.Feature.second.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.first.FirstEvent
import com.example.testcmp.Feature.first.FirstState
import com.example.testcmp.Feature.first.FirstViewModel
import com.example.testcmp.Feature.second.SecondEvent
import com.example.testcmp.Feature.second.SecondState
import com.example.testcmp.Feature.second.SecondViewModel

@Composable
fun SecondScreen(viewModel: SecondViewModel) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        SecondScreenView(
            state = state,
            onUiEvent = viewModel::pushEvent)
    }
}

@Composable
fun SecondScreenView(state: SecondState,
                    onUiEvent: (SecondEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello from cmp")
    }
}