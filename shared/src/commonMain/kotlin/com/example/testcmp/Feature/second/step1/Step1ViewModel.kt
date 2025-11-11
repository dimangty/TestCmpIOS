package com.example.testcmp.Feature.second.step1

import com.example.testcmp.Base.BaseViewModel

class Step1ViewModel: BaseViewModel<Step1State, Step1Event>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): Step1State = Step1State()

    override fun onEvent(event: Step1Event) {
        when (event) {
            is Step1Event.BackClick -> navigateBack()
            is Step1Event.ContinueClick -> {
                // Navigate to next step will be handled by parent
            }
        }
    }
}