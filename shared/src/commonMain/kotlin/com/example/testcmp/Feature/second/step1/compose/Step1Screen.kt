package com.example.testcmp.Feature.second.step1.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.second.step1.Step1Event
import com.example.testcmp.Feature.second.step1.Step1State
import com.example.testcmp.Feature.second.step1.Step1ViewModel

@Composable
fun Step1Screen(
    viewModel: Step1ViewModel,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        Step1ScreenView(
            state = state,
            onBackClick = onBackClick,
            onContinueClick = onContinueClick
        )
    }
}

@Composable
fun Step1ScreenView(
    state: Step1State,
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
            text = "Step 1",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // No back button on step 1 as it's the first step
            Spacer(modifier = Modifier.weight(1f).padding(end = 8.dp))

            Button(
                onClick = onContinueClick,
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("Continue")
            }
        }
    }
}