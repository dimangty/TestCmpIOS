package com.example.testcmp.Feature.second.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.second.SecondEvent
import com.example.testcmp.Feature.second.SecondState
import com.example.testcmp.Feature.second.SecondViewModel
import com.example.testcmp.Feature.second.StepType
import com.example.testcmp.Feature.second.step1.Step1ViewModel
import com.example.testcmp.Feature.second.step1.compose.Step1Screen
import com.example.testcmp.Feature.second.step2.Step2ViewModel
import com.example.testcmp.Feature.second.step2.compose.Step2Screen
import com.example.testcmp.Feature.second.step3.Step3ViewModel
import com.example.testcmp.Feature.second.step3.compose.Step3Screen
import com.example.testcmp.Feature.second.step4.Step4ViewModel
import com.example.testcmp.Feature.second.step4.compose.Step4Screen
import com.example.testcmp.getKoinInstance

@Composable
fun SecondScreen(viewModel: SecondViewModel) {
    val state by viewModel.flowState.collectAsState()
    val lceState by viewModel.lceState.collectAsState()
    val currentStep by viewModel.getCurrentStep().collectAsState()

    BaseScreen(lceState = lceState,
        onDefaultUiEvent = viewModel::onDefaultUiEvent) {
        SecondScreenView(
            state = state,
            currentStep = currentStep,
            onUiEvent = viewModel::pushEvent)
    }
}

@Composable
fun SecondScreenView(
    state: SecondState,
    currentStep: StepType,
    onUiEvent: (SecondEvent) -> Unit
) {
    // Create ViewModels for each step using getKoinInstance
    val step1ViewModel: Step1ViewModel = remember { getKoinInstance() }
    val step2ViewModel: Step2ViewModel = remember { getKoinInstance() }
    val step3ViewModel: Step3ViewModel = remember { getKoinInstance() }
    val step4ViewModel: Step4ViewModel = remember { getKoinInstance() }

    Column(modifier = Modifier.fillMaxSize()) {
        StepIndicator(
            currentStep = currentStep,
            modifier = Modifier.fillMaxWidth()
        )

        when (currentStep) {
            StepType.STEP_1 -> {
                Step1Screen(
                    viewModel = step1ViewModel,
                    onBackClick = {
                        onUiEvent(SecondEvent.NavigateBack)
                    },
                    onContinueClick = {
                        onUiEvent(SecondEvent.NextStep)
                    }
                )
            }
            StepType.STEP_2 -> {
                Step2Screen(
                    viewModel = step2ViewModel,
                    onBackClick = {
                        onUiEvent(SecondEvent.PreviousStep)
                    },
                    onContinueClick = {
                        onUiEvent(SecondEvent.NextStep)
                    }
                )
            }
            StepType.STEP_3 -> {
                Step3Screen(
                    viewModel = step3ViewModel,
                    onBackClick = {
                        onUiEvent(SecondEvent.PreviousStep)
                    },
                    onContinueClick = {
                        onUiEvent(SecondEvent.NextStep)
                    }
                )
            }
            StepType.STEP_4 -> {
                Step4Screen(
                    viewModel = step4ViewModel,
                    onBackClick = {
                        onUiEvent(SecondEvent.PreviousStep)
                    },
                    onFinishClick = {
                        onUiEvent(SecondEvent.NavigateBack)
                    }
                )
            }
        }
    }
}