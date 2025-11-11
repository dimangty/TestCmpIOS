package com.example.testcmp.Feature.second

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StepService {
    private val _currentStep = MutableStateFlow(StepType.STEP_1)
    val currentStep: StateFlow<StepType> = _currentStep.asStateFlow()

    fun setStep(step: StepType) {
        _currentStep.value = step
    }

    fun nextStep() {
        val currentStepNumber = _currentStep.value.stepNumber
        if (currentStepNumber < 4) {
            val nextStep = StepType.fromStepNumber(currentStepNumber + 1)
            _currentStep.value = nextStep
        }
    }

    fun previousStep() {
        val currentStepNumber = _currentStep.value.stepNumber
        if (currentStepNumber > 1) {
            val previousStep = StepType.fromStepNumber(currentStepNumber - 1)
            _currentStep.value = previousStep
        }
    }

    fun canGoNext(): Boolean = _currentStep.value.stepNumber < 4

    fun canGoBack(): Boolean = _currentStep.value.stepNumber > 1
}