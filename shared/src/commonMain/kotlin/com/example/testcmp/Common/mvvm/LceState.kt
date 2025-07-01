package com.example.testcmp.Common.mvvm

data class LceState(
    val isLoading: Boolean = false,
    val errorState: ErrorState? = null,
    val isRootScreen: Boolean = false,
)