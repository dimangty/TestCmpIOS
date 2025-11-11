package com.example.testcmp.Feature.second.step3.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.second.step3.Step3Event
import com.example.testcmp.Feature.second.step3.Step3State
import com.example.testcmp.Feature.second.step3.Step3ViewModel

@Composable
fun Step3Screen(
    viewModel: Step3ViewModel
) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        Step3ScreenView(
            state = state,
            viewModel = viewModel
        )
    }
}

@Composable
fun Step3ScreenView(
    state: Step3State,
    viewModel: Step3ViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Step 3",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { viewModel.pushEvent(Step3Event.BackClick) },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("Back")
            }

            Button(
                onClick = { viewModel.pushEvent(Step3Event.ContinueClick) },
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("Continue")
            }
        }
    }
}
