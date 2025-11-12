//
//  SecondScreenViewModel.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

import Combine
import Foundation
import shared

final class SecondScreenViewModel: ObservableObject {
    let mViewModel: shared.SecondViewModel
    
    required init() {
        mViewModel = SecondViewModel()
        observe()
    }

    // MARK: - SecondScreenViewOutput methods
    func didLoad() {
        
    }
    
    func observe() {
        mViewModel.navigationEffectFlow.watch { [weak self] effect in
            print("iOS ViewModel: Received navigation effect: \(effect)")
            DispatchQueue.main.async {
                if effect is NavigationAction.NavigateBack {
                    print("iOS ViewModel: Executing pop navigation")
                    NavigationService.shared.pop()
                }
            }
        }
    }

}

// MARK: - SecondScreenModuleInput methods
extension SecondScreenViewModel: SecondScreenModuleInput {

    func configure(data: SecondScreenConfigData) {

    }

}
