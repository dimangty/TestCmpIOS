package com.example.testcmp.Feature.second.step4.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.second.step4.Step4Event
import com.example.testcmp.Feature.second.step4.Step4State
import com.example.testcmp.Feature.second.step4.Step4ViewModel

@Composable
fun Step4Screen(
    viewModel: Step4ViewModel,
    onBackClick: () -> Unit,
    onFinishClick: () -> Unit
) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        Step4ScreenView(
            state = state,
            onBackClick = onBackClick,
            onFinishClick = onFinishClick
        )
    }
}

@Composable
fun Step4ScreenView(
    state: Step4State,
    onBackClick: () -> Unit,
    onFinishClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Step 4 (Final)",
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
                onClick = onFinishClick,
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("Finish")
            }
        }
    }
}