package com.example.testcmp.Feature.second.step3

import com.example.testcmp.Base.BaseViewModel
import com.example.testcmp.Feature.second.StepService

class Step3ViewModel(
    private val stepService: StepService
) : BaseViewModel<Step3State, Step3Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step3State = Step3State()

    override fun onEvent(event: Step3Event) {
        when (event) {
            is Step3Event.BackClick -> stepService.previousStep()
            is Step3Event.ContinueClick -> stepService.nextStep()
        }
    }
}
