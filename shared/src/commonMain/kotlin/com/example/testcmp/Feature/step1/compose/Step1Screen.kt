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
import com.example.testcmp.Navigation.NavigationAction
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.testcmp.getKoinInstance

fun NavGraphBuilder.navRouteStep1() {
    composable<NavigationAction.NavigateToStep1> {
        Step1Screen()
    }
}

@Composable
fun Step1Screen(
    viewModel: Step1ViewModel = getKoinInstance(),
    goBack: (() -> Unit)? = null
) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        Step1ScreenView(
            state = state,
            viewModel = viewModel,
            goBack = goBack
        )
    }
}

@Composable
fun Step1ScreenView(
    state: Step1State,
    viewModel: Step1ViewModel,
    goBack: (() -> Unit)? = null
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
            Button(
                onClick = {
                    goBack?.invoke() ?: viewModel.pushEvent(Step1Event.BackClick)
                },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("Back")
            }

            Button(
                onClick = { viewModel.pushEvent(Step1Event.ContinueClick) },
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("Continue")
            }
        }
    }
}
