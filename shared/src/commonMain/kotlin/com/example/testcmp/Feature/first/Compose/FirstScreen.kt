package com.example.testcmp.Feature.first.Compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.first.FirstEvent
import com.example.testcmp.Feature.first.FirstState
import com.example.testcmp.Feature.first.FirstViewModel

@Composable
fun FirstScreen(viewModel: FirstViewModel) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        FirstScreenView(
            state = state,
            onUiEvent = viewModel::pushEvent)
    }
}

@Composable
fun FirstScreenView(state: FirstState,
                    onUiEvent: (FirstEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {onUiEvent(FirstEvent.ClickEvent())}) {
            Text("Click Me")
        }
    }
}