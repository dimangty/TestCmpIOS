package com.example.testcmp.Feature.first

import com.example.testcmp.Base.BaseEvent

sealed class FirstEvent: BaseEvent {
    class ClickEvent: FirstEvent()
}