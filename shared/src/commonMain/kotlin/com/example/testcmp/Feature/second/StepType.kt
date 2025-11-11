package com.example.testcmp.Feature.second

enum class StepType(val stepNumber: Int, val label: String) {
    STEP_1(1, "Step 1"),
    STEP_2(2, "Step 2"),
    STEP_3(3, "Step 3"),
    STEP_4(4, "Step 4");

    companion object {
        fun fromStepNumber(stepNumber: Int): StepType {
            return values().find { it.stepNumber == stepNumber } ?: STEP_1
        }
    }
}