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
        mViewModel = inject()
    }

    // MARK: - SecondScreenViewOutput methods
    func didLoad() {
        
    }

}

// MARK: - SecondScreenModuleInput methods
extension SecondScreenViewModel: SecondScreenModuleInput {

    func configure(data: SecondScreenConfigData) {

    }

}
