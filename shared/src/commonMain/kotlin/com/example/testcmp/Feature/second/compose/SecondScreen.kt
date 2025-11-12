package com.example.testcmp.Feature.second.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import com.example.testcmp.Navigation.NavigationAction
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SecondScreenView(
    state: SecondState,
    currentStep: StepType,
    navController: NavHostController = rememberNavController(),
    onUiEvent: (SecondEvent) -> Unit
) {
    BackHandler {
        if (currentStep != StepType.STEP_1) {
            onUiEvent(SecondEvent.PreviousStep)
        } else {
            onUiEvent(SecondEvent.NavigateBack)
        }
    }

    LaunchedEffect(currentStep) {
        val targetRoute = when (currentStep) {
            StepType.STEP_1 -> NavigationAction.NavigateToStep1
            StepType.STEP_2 -> NavigationAction.NavigateToStep2
            StepType.STEP_3 -> NavigationAction.NavigateToStep3
            StepType.STEP_4 -> NavigationAction.NavigateToStep4
        }
        navController.navigate(targetRoute) {
            launchSingleTop = true
        }
    }

    // Observe current navigation destination and sync step indicator
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    LaunchedEffect(currentBackStackEntry) {
        currentBackStackEntry?.destination?.route?.let { route ->
            val stepFromRoute = when (route) {
                NavigationAction.NavigateToStep1::class.qualifiedName -> StepType.STEP_1
                NavigationAction.NavigateToStep2::class.qualifiedName -> StepType.STEP_2
                NavigationAction.NavigateToStep3::class.qualifiedName -> StepType.STEP_3
                NavigationAction.NavigateToStep4::class.qualifiedName -> StepType.STEP_4
                else -> null
            }
            stepFromRoute?.let { step ->
                if (step != currentStep) {
                    onUiEvent(SecondEvent.SetStep(step))
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StepIndicator(
            currentStep = currentStep,
            modifier = Modifier.fillMaxWidth()
        )
        SignUpNavigationGraph(navController)
    }
}

@Composable
fun SignUpNavigationGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationAction.NavigateToStep1,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } },
        modifier = Modifier
            .fillMaxSize()
//            .background(color = EpsColor)
    ) {
        initSignUpRoutes()
    }
}

fun NavGraphBuilder.initSignUpRoutes() {
    step1Route()
    step2Route()
    step3Route()
    step4Route()
}

fun NavGraphBuilder.step1Route() {
    composable<NavigationAction.NavigateToStep1> {
        Step1Screen()
    }
}

fun NavGraphBuilder.step2Route() {
    composable<NavigationAction.NavigateToStep2> {
        Step2Screen()
    }
}

fun NavGraphBuilder.step3Route() {
    composable<NavigationAction.NavigateToStep3> {
        Step3Screen(viewModel = getKoinInstance())
    }
}

fun NavGraphBuilder.step4Route() {
    composable<NavigationAction.NavigateToStep4> {
        Step4Screen(viewModel = getKoinInstance())
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
