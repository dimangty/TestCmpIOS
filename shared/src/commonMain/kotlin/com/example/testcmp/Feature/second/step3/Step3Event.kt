package com.example.testcmp.Feature.second.step3

import com.example.testcmp.Base.BaseEvent

sealed class Step3Event: BaseEvent {
    data object BackClick: Step3Event()
    data object ContinueClick: Step3Event()
}