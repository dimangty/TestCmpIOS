//
//  FirstScreenAssembly.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

import UIKit

// For module inputs and outputs
typealias FirstScreenConfiguration = (FirstScreenModuleInput) -> (Void)

final class FirstScreenModuleAssembly {

    /// Assembles Module components and returns a target controller
    ///
    /// - Parameter configuration: optional configuration closure called by module owner
    /// - Returns: Assembled module's ViewController
    func assemble(_ configuration: FirstScreenConfiguration? = nil) -> UIViewController {
        // let viewModel = FirstScreenViewModel()
        let view = FirstScreenView()
        let hostingController = FirstScreenHostingController(rootView: view)
        // hostingController.viewModel = viewModel
        // configuration?(viewModel)
        return hostingController
    }

}
