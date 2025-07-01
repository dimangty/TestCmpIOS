//
//  SecondScreenAssembly.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

import UIKit

// For module inputs and outputs
typealias SecondScreenConfiguration = (SecondScreenModuleInput) -> (Void)

final class SecondScreenModuleAssembly {

    /// Assembles Module components and returns a target controller
    ///
    /// - Parameter configuration: optional configuration closure called by module owner
    /// - Returns: Assembled module's ViewController
    func assemble(_ configuration: SecondScreenConfiguration? = nil) -> UIViewController {
        // let viewModel = SecondScreenViewModel()
        let view = SecondScreenView()
        let hostingController = SecondScreenHostingController(rootView: view)
        // hostingController.viewModel = viewModel
        // configuration?(viewModel)
        return hostingController
    }

}
