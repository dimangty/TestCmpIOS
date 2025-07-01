//
//  SecondScreenModuleInput.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

/// Adapter struct for SecondScreen initial configuration through SecondScreenModuleInput
struct SecondScreenConfigData {

}

/// Protocol with public methods to configure SecondScreen from its parent module (usually implemented by this module's ViewModel)
protocol SecondScreenModuleInput: AnyObject {

	/// public configuration method for parent modules (add configurating parameters)
    func configure(data: SecondScreenConfigData)

}
