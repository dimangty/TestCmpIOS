package com.example.testcmp.Feature.device

actual class DeviceService {
    actual fun isAndroid(): Boolean {
        return true
    }

    actual fun isIOS(): Boolean {
        return false
    }
}