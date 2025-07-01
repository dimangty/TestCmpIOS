package com.example.testcmp.Feature.device

expect class DeviceService {
    fun isAndroid(): Boolean
    fun isIOS(): Boolean
}