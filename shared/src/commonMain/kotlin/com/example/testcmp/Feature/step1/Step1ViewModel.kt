package com.example.testcmp.Feature.second.step1

import com.example.testcmp.Base.BaseViewModel
import com.example.testcmp.Feature.second.StepService

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
            is Step1Event.BackClick -> stepService.previousStep()
            is Step1Event.ContinueClick -> stepService.nextStep()
        }
    }
}
