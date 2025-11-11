//
//  SecondScreenView.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

import SwiftUI
import shared

struct SecondScreenView: View {

    @StateObject private var viewModel = SecondScreenViewModel()

    var body: some View {
        ComposeWrapper {
            ViewControllersKt.SecondViewController(viewModel: viewModel.mViewModel)
        }
        .navigationBarHidden(true)
        .highPriorityGesture(
            DragGesture(minimumDistance: 20)
                .onEnded { value in
                    // iOS-style swipe back from left edge to dismiss the screen
                    if value.startLocation.x < 80 && value.translation.width > 80 {
                        let canGoBack = viewModel.mViewModel.canGoBack()

                        print("iOS Gesture: canGoBack=\(canGoBack), startX=\(value.startLocation.x), dragX=\(value.translation.width)")

                        // If we're on step 1 (can't go back within flow), navigate back to previous screen
                        if !canGoBack {
                            print("iOS Gesture: Triggering NavigateBack")
                            viewModel.mViewModel.pushEvent(event: SecondEvent.NavigateBack())
                        }
                        // Otherwise handle step navigation - NavHost will handle the UI transition
                        else {
                            print("iOS Gesture: Triggering PreviousStep")
                            viewModel.mViewModel.pushEvent(event: SecondEvent.PreviousStep())
                        }
                    }
                }
        )
    }

}

#Preview {
    SecondScreenView()
}
