package com.example.testcmp.Feature.second.step2.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.second.step2.Step2Event
import com.example.testcmp.Feature.second.step2.Step2State
import com.example.testcmp.Feature.second.step2.Step2ViewModel

@Composable
fun Step2Screen(
    viewModel: Step2ViewModel,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        Step2ScreenView(
            state = state,
            onBackClick = onBackClick,
            onContinueClick = onContinueClick
        )
    }
}

@Composable
fun Step2ScreenView(
    state: Step2State,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Step 2",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onBackClick,
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("Back")
            }

            Button(
                onClick = onContinueClick,
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("Continue")
            }
        }
    }
}