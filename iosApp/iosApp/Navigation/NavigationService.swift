//
//  NavigationService.swift
//  iosApp
//
//  Created by Дмитрий Быков on 01.07.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import Combine

class NavigationService: ObservableObject {
    @Published var path: [NavigationDestination] = []
    static let shared = NavigationService()
    
    func push(_ destination: NavigationDestination) {
        path.append(destination)
    }
    
    func pop() {
        if path.count > 0 {
            path.removeLast()
        }
    }
}
