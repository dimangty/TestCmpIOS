package com.example.testcmp.Feature.second.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testcmp.Base.ui.BaseScreen
import com.example.testcmp.Feature.second.SecondEvent
import com.example.testcmp.Feature.second.SecondState
import com.example.testcmp.Feature.second.SecondViewModel
import com.example.testcmp.Feature.second.StepType
import com.example.testcmp.Feature.second.step1.Step1Event
import com.example.testcmp.Feature.second.step1.Step1ViewModel
import com.example.testcmp.Feature.second.step1.compose.Step1Screen
import com.example.testcmp.Feature.second.step2.Step2ViewModel
import com.example.testcmp.Feature.second.step2.compose.Step2Screen
import com.example.testcmp.Feature.second.step3.Step3ViewModel
import com.example.testcmp.Feature.second.step3.compose.Step3Screen
import com.example.testcmp.Feature.second.step4.Step4Event
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
    val navController = rememberNavController()

    LaunchedEffect(step1ViewModel) {
        step1ViewModel.events.collect { event ->
            when (event) {
                Step1Event.BackClick -> onUiEvent(SecondEvent.NavigateBack)
                Step1Event.ContinueClick -> Unit
            }
        }
    }

    LaunchedEffect(step4ViewModel) {
        step4ViewModel.events.collect { event ->
            when (event) {
                Step4Event.BackClick -> Unit
                Step4Event.FinishClick -> onUiEvent(SecondEvent.NavigateBack)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        StepIndicator(
            currentStep = currentStep,
            modifier = Modifier.fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            NavHost(
                navController = navController,
                startDestination = StepNavRoute.Step1.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(StepNavRoute.Step1.route) {
                    Step1Screen(viewModel = step1ViewModel)
                }
                composable(StepNavRoute.Step2.route) {
                    Step2Screen(viewModel = step2ViewModel)
                }
                composable(StepNavRoute.Step3.route) {
                    Step3Screen(viewModel = step3ViewModel)
                }
                composable(StepNavRoute.Step4.route) {
                    Step4Screen(viewModel = step4ViewModel)
                }
            }
        }
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { entry ->
            entry.destination.route
                .toStepType()
                ?.let { onUiEvent(SecondEvent.SetStep(it)) }
        }
    }

    LaunchedEffect(currentStep, navController) {
        val targetRoute = currentStep.toRoute()
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        if (currentRoute == targetRoute) return@LaunchedEffect

        if (targetRoute == StepNavRoute.Step1.route) {
            navController.popBackStack(
                StepNavRoute.Step1.route,
                inclusive = false
            )
        } else {
            navController.navigate(targetRoute) {
                popUpTo(StepNavRoute.Step1.route) {
                    inclusive = false
                }
                launchSingleTop = true
            }
        }
    }
}

private enum class StepNavRoute(val route: String) {
    Step1("step1"),
    Step2("step2"),
    Step3("step3"),
    Step4("step4");
}

private fun StepType.toRoute(): String = when (this) {
    StepType.STEP_1 -> StepNavRoute.Step1.route
    StepType.STEP_2 -> StepNavRoute.Step2.route
    StepType.STEP_3 -> StepNavRoute.Step3.route
    StepType.STEP_4 -> StepNavRoute.Step4.route
}

private fun String?.toStepType(): StepType? = when (this) {
    StepNavRoute.Step1.route -> StepType.STEP_1
    StepNavRoute.Step2.route -> StepType.STEP_2
    StepNavRoute.Step3.route -> StepType.STEP_3
    StepNavRoute.Step4.route -> StepType.STEP_4
    else -> null
}
