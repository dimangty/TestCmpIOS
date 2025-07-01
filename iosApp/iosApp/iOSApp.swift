import SwiftUI
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate
    @StateObject private var navigationService = NavigationService.shared
    
    var body: some Scene {
        WindowGroup {
            NavigationStack(path: $navigationService.path) {
                FirstScreenView()
                    .navigationDestination(for: NavigationDestination.self) { destination in
                        switch destination {
                        case .first:
                            FirstScreenView()
                        case .second:
                            SecondScreenView()
                        }
                    }
            }.environmentObject(navigationService)
            
            
            
        }
    }
}


class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool  {
        KoinApplication.start()
        
        return true
    }
}
