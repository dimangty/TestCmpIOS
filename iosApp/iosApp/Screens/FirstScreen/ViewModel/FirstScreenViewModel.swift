//
//  FirstScreenViewModel.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

import Combine
import Foundation
import shared

final class FirstScreenViewModel: ObservableObject {
    let mViewModel: shared.FirstViewModel

    required init() {
        mViewModel = FirstViewModel()
        observe()
    }

    // MARK: - FirstScreenViewOutput methods
    func didLoad() {
        
    }
    
    func observe() {
        mViewModel.navigationEffectFlow.watch { [weak self] effect in
            if effect is NavigationAction.NavigateToSecond {
                NavigationService.shared.push(.second)
            }
        }
    }
        

}

// MARK: - FirstScreenModuleInput methods
extension FirstScreenViewModel: FirstScreenModuleInput {

    func configure(data: FirstScreenConfigData) {

    }

}
