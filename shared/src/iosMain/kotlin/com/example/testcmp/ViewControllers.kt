package com.example.testcmp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.testcmp.Feature.first.Compose.FirstScreen
import com.example.testcmp.Feature.first.FirstViewModel
import com.example.testcmp.Feature.second.SecondViewModel
import com.example.testcmp.Feature.second.compose.SecondScreen

fun MyScreenViewController() = ComposeUIViewController  {
    MyScreen()
}

fun FirstViewController(viewModel: FirstViewModel) = ComposeUIViewController {
    FirstScreen(viewModel)
}

fun SecondViewController(viewModel: SecondViewModel) = ComposeUIViewController {
    SecondScreen(viewModel)
}