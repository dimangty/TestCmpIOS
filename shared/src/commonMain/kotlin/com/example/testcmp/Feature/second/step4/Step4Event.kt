package com.example.testcmp.Feature.second.step4

import com.example.testcmp.Base.BaseEvent

sealed class Step4Event: BaseEvent {
    data object BackClick: Step4Event()
    data object FinishClick: Step4Event()
}