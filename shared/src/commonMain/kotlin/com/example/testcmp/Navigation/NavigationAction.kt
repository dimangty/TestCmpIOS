package com.example.testcmp.Navigation
import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationAction {
    @Serializable
    data object NavigateToSecond : NavigationAction()

    @Serializable
    data object NavigateBack : NavigationAction()

}