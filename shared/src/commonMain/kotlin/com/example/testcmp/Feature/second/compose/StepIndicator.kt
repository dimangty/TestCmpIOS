package com.example.testcmp.Feature.second.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcmp.Feature.second.StepType

@Composable
fun StepIndicator(
    currentStep: StepType,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(4) { index ->
            val stepNumber = index + 1
            val isCurrentStep = currentStep.stepNumber == stepNumber
            val isCompletedStep = currentStep.stepNumber > stepNumber

            StepIndicatorItem(
                stepNumber = stepNumber,
                isCurrentStep = isCurrentStep,
                isCompletedStep = isCompletedStep
            )

            if (index < 3) {
                StepConnector(isCompleted = isCompletedStep)
            }
        }
    }
}

@Composable
private fun StepIndicatorItem(
    stepNumber: Int,
    isCurrentStep: Boolean,
    isCompletedStep: Boolean
) {
    val backgroundColor = when {
        isCurrentStep -> MaterialTheme.colorScheme.primary
        isCompletedStep -> MaterialTheme.colorScheme.primary
        else -> Color.Gray
    }

    val textColor = when {
        isCurrentStep || isCompletedStep -> Color.White
        else -> Color.Black
    }

    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stepNumber.toString(),
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun StepConnector(
    isCompleted: Boolean
) {
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(2.dp)
            .background(
                if (isCompleted) MaterialTheme.colorScheme.primary else Color.Gray
            )
    )
}