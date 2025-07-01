//
//  FirstScreenView.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

import SwiftUI
import shared

struct FirstScreenView: View {

    @StateObject private var viewModel = FirstScreenViewModel()

    var body: some View {
        ComposeWrapper {
            ViewControllersKt
                .FirstViewController(viewModel: viewModel.mViewModel)
        }
        
            
    }

}

#Preview {
    FirstScreenView()
}
