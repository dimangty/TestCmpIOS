package com.example.testcmp.Feature.second

import com.example.testcmp.Base.BaseEvent
import com.example.testcmp.Feature.contacts.ContactInfo

sealed class SecondEvent: BaseEvent {
    data class ContactPicked(val contact: ContactInfo?) : SecondEvent()
}
