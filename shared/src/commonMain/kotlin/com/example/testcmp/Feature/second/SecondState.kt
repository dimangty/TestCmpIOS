package com.example.testcmp.Feature.second

import com.example.testcmp.Base.BaseViewState

data class SecondState(
    val name: String = "sad",
    val contactName: String? = null,
    val contactPhone: String? = null
) : BaseViewState
