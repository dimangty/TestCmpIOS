package com.example.testcmp.Feature.second.step1

import com.example.testcmp.Base.BaseEvent

sealed class Step1Event: BaseEvent {
    data object BackClick: Step1Event()
    data object ContinueClick: Step1Event()
}