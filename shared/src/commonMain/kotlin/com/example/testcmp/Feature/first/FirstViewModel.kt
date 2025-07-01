package com.example.testcmp.Feature.first

import com.example.testcmp.Base.BaseViewModel
import com.example.testcmp.Navigation.NavigationAction

class FirstViewModel: BaseViewModel<FirstState, FirstEvent>() {

    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): FirstState = FirstState()

    override fun onEvent(event: FirstEvent) {
        when(event) {
            is FirstEvent.ClickEvent -> {
                navigate(NavigationAction.NavigateToSecond)
            }
        }
    }
}