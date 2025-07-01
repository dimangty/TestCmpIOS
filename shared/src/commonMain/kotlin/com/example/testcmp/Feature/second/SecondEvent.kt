package com.example.testcmp.Feature.second

import com.example.testcmp.Base.BaseEvent
import com.example.testcmp.Feature.first.FirstEvent

sealed class SecondEvent: BaseEvent {
    class ClickEvent: SecondEvent()
}