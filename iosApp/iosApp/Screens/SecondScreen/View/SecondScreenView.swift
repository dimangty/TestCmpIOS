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
    }
}

#Preview {
    SecondScreenView()
}
