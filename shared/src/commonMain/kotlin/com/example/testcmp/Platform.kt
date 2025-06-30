package com.example.testcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform