//
//  FirstScreenModuleInput.swift
//  EPS
//
//  Created by Dmitry on 01/07/2025.
//  Copyright © 2025 EPS. All rights reserved.
//

/// Adapter struct for FirstScreen initial configuration through FirstScreenModuleInput
struct FirstScreenConfigData {

}

/// Protocol with public methods to configure FirstScreen from its parent module (usually implemented by this module's ViewModel)
protocol FirstScreenModuleInput: AnyObject {

	/// public configuration method for parent modules (add configurating parameters)
    func configure(data: FirstScreenConfigData)

}
