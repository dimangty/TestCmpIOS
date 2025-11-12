package com.example.testcmp.Feature.second.step1

import androidx.lifecycle.viewModelScope
import com.example.testcmp.Base.BaseViewModel
import com.example.testcmp.Feature.second.StepService
import com.example.testcmp.Feature.second.SecondViewModel
import com.example.testcmp.Navigation.NavigationAction
import kotlinx.coroutines.launch

class Step1ViewModel(
    private val stepService: StepService
) : BaseViewModel<Step1State, Step1Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step1State = Step1State()

    override fun onEvent(event: Step1Event) {
        when (event) {
            is Step1Event.BackClick -> {
                if (stepService.canGoBack()) {
                    stepService.previousStep()
                } else {
                    // Use shared navigation coordinator so iOS can observe it
                    viewModelScope.launch {
                        SecondViewModel.emitNavigationEffect(NavigationAction.NavigateBack)
                    }
                }
            }
            is Step1Event.ContinueClick -> stepService.nextStep()
        }
    }
}
