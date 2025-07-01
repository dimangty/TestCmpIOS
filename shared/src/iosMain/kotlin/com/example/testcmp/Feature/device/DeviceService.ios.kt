package com.example.testcmp.Feature.device

actual class DeviceService {
    actual fun isAndroid(): Boolean {
        return false
    }

    actual fun isIOS(): Boolean {
        return true
    }
}