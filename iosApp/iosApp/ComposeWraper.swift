//
//  ComposeWraper.swift
//  iosApp
//
//  Created by Дмитрий Быков on 30.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ComposeWrapper: UIViewControllerRepresentable {
    typealias UIViewControllerType = UIViewController
    
    let createViewController: () -> UIViewController

    func makeUIViewController(context: Context) -> UIViewController {
        createViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        // No-op for now
    }
}
