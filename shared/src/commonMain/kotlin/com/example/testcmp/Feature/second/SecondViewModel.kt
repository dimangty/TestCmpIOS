package com.example.testcmp.Feature.second

import com.example.testcmp.Base.BaseViewModel
import org.koin.mp.KoinPlatform.getKoin
import kotlinx.coroutines.flow.*
import com.example.testcmp.Navigation.NavigationAction
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.testcmp.Feature.device.DeviceService

class SecondViewModel: BaseViewModel<SecondState, SecondEvent>() {
    private val stepService by getKoin().inject<StepService>()
    private val deviceService by getKoin().inject<DeviceService>()

    // Create a shared navigation coordinator for all step ViewModels
    companion object {
        private val _sharedNavigationEffect = MutableSharedFlow<NavigationAction>()
        val sharedNavigationFlow = _sharedNavigationEffect.asSharedFlow()

        suspend fun emitNavigationEffect(effect: NavigationAction) {
            _sharedNavigationEffect.emit(effect)
        }
    }

    init {
        // Observe shared navigation effects and emit them through this ViewModel's flow
        observeSharedNavigation()
    }

    private fun observeSharedNavigation() {
        viewModelScope.launch {
            sharedNavigationFlow.collect { effect ->
                if (deviceService.isIOS()) {
                    // Use the parent's navigation method instead of accessing private field
                    when (effect) {
                        is NavigationAction.NavigateBack -> navigateBack()
                        else -> { /* Handle other navigation effects if needed */ }
                    }
                }
            }
        }
    }
    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): SecondState = SecondState()

    override fun onEvent(event: SecondEvent) {
        when (event) {
            is SecondEvent.ClickEvent -> {}
            is SecondEvent.NextStep -> stepService.nextStep()
            is SecondEvent.PreviousStep -> stepService.previousStep()
            is SecondEvent.NavigateBack -> navigateBack()
            is SecondEvent.SetStep -> stepService.setStep(event.step)
        }
    }

    fun getCurrentStep() = stepService.currentStep
    fun canGoNext() = stepService.canGoNext()
    fun canGoBack() = stepService.canGoBack()

}