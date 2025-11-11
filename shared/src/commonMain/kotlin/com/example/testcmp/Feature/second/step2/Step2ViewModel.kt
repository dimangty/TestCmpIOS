package com.example.testcmp.Feature.second.step2

import com.example.testcmp.Base.BaseViewModel

class Step2ViewModel: BaseViewModel<Step2State, Step2Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step2State = Step2State()

    override fun onEvent(event: Step2Event) {
        when (event) {
            is Step2Event.BackClick -> {
                // Navigate to previous step will be handled by parent
            }
            is Step2Event.ContinueClick -> {
                // Navigate to next step will be handled by parent
            }
        }
    }
}