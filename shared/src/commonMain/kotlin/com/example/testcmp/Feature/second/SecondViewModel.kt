package com.example.testcmp.Feature.second

import com.example.testcmp.Base.BaseViewModel
import org.koin.mp.KoinPlatform.getKoin

class SecondViewModel: BaseViewModel<SecondState, SecondEvent>() {
    private val stepService by getKoin().inject<StepService>()
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