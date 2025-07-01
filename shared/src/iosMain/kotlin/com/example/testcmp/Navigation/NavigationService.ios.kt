package com.example.testcmp.Navigation

import com.example.testcmp.asCommonFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform.getKoin
import com.example.testcmp.DEFAULT_SCOPE

actual class NavigationService {
    private val localScope = getKoin().get<CoroutineScope>(
        named(DEFAULT_SCOPE)
    )

    private val _navigationFlow = MutableSharedFlow<NavigationAction>()
    val navigationFlow = _navigationFlow.asCommonFlow()

    actual fun navigate(action: NavigationAction) {
        localScope.launch {
            _navigationFlow.emit(action)
        }
    }

    actual fun navigateBack() {
        localScope.launch {
            _navigationFlow.emit(NavigationAction.NavigateBack)
        }
    }

    actual val currentDestination = MutableStateFlow("").asStateFlow()

    actual fun <T> setPreviousBackStackEntry(key: String, value: T) {
        // empty
    }

    actual fun <T> getCurrentBackStackEntry(key: String): T? {
        return null
    }

    actual fun <T> clearCurrentBackStackEntry(key: String) {
        // empty
    }
}