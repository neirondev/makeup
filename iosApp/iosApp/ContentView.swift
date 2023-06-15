import SwiftUI
import shared

struct ContentView: View {
    @EnvironmentObject private var makeUpViewModel :MakeUpViewModel
    
    let greet = Greeting().greet()

	var body: some View {
      HomeView()
      //  Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
