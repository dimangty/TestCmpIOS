package com.example.testcmp.Navigation
import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationAction {
    @Serializable
    data object NavigateToSecond : NavigationAction()

    @Serializable
    data object NavigateBack : NavigationAction()

    @Serializable
    data object NavigateToStep1 : NavigationAction()

    @Serializable
    data object NavigateToStep2 : NavigationAction()

    @Serializable
    data object NavigateToStep3 : NavigationAction()

    @Serializable
    data object NavigateToStep4 : NavigationAction()

}