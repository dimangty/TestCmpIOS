package com.example.testcmp

import com.example.testcmp.Feature.device.DeviceService
import com.example.testcmp.Feature.first.FirstViewModel
import com.example.testcmp.Feature.second.SecondViewModel
import com.example.testcmp.Navigation.NavigationService
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal actual val platformModule: Module  = module {
    singleOf(::DeviceService)
    singleOf(::NavigationService)
    viewModelOf(::FirstViewModel)
    viewModelOf(::SecondViewModel)
}