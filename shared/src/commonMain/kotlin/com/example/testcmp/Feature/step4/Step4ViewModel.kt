package com.example.testcmp.Feature.second.step4

import com.example.testcmp.Base.BaseViewModel
import com.example.testcmp.Feature.second.StepService

class Step4ViewModel(
    private val stepService: StepService
) : BaseViewModel<Step4State, Step4Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step4State = Step4State()

    override fun onEvent(event: Step4Event) {
        when (event) {
            is Step4Event.BackClick -> stepService.previousStep()
            is Step4Event.FinishClick -> stepService.nextStep()
        }
    }
}
