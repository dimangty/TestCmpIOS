package com.example.testcmp.Feature.second

import com.example.testcmp.Base.BaseViewModel

class SecondViewModel: BaseViewModel<SecondState, SecondEvent>() {
    override fun initToolbar() {

    }

    override fun initScreenData() {

    }

    override fun initialState(): SecondState = SecondState()

    override fun onEvent(event: SecondEvent) {
        when (event) {
            is SecondEvent.ContactPicked -> {
                updateState {
                    copy(
                        contactName = event.contact?.name,
                        contactPhone = event.contact?.phone
                    )
                }
            }
        }
    }

}
