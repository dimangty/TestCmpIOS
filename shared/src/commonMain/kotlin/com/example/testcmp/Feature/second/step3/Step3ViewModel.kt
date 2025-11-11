package com.example.testcmp.Feature.second.step3

import com.example.testcmp.Base.BaseViewModel

class Step3ViewModel: BaseViewModel<Step3State, Step3Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step3State = Step3State()

    override fun onEvent(event: Step3Event) {
        when (event) {
            is Step3Event.BackClick -> {
                // Navigate to previous step will be handled by parent
            }
            is Step3Event.ContinueClick -> {
                // Navigate to next step will be handled by parent
            }
        }
    }
}