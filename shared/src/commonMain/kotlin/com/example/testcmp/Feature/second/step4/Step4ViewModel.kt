package com.example.testcmp.Feature.second.step4

import com.example.testcmp.Base.BaseViewModel

class Step4ViewModel: BaseViewModel<Step4State, Step4Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step4State = Step4State()

    override fun onEvent(event: Step4Event) {
        when (event) {
            is Step4Event.BackClick -> {
                // Navigate to previous step will be handled by parent
            }
            is Step4Event.FinishClick -> {
                // Finish the flow, will be handled by parent
            }
        }
    }
}