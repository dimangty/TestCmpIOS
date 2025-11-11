package com.example.testcmp.Feature.second.step2

import com.example.testcmp.Base.BaseEvent

sealed class Step2Event: BaseEvent {
    data object BackClick: Step2Event()
    data object ContinueClick: Step2Event()
}