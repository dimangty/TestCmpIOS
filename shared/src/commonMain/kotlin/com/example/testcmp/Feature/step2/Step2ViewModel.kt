package com.example.testcmp.Feature.second.step2

import com.example.testcmp.Base.BaseViewModel
import com.example.testcmp.Feature.second.StepService

class Step2ViewModel(
    private val stepService: StepService
) : BaseViewModel<Step2State, Step2Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step2State = Step2State()

    override fun onEvent(event: Step2Event) {
        when (event) {
            is Step2Event.BackClick -> stepService.previousStep()
            is Step2Event.ContinueClick -> stepService.nextStep()
        }
    }
}
