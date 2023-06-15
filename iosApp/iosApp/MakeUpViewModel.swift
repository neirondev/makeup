//
//  MakeUpViewModel.swift
//  iosApp
//
//  Created by denis on 08.06.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
let TAG = "MakeUpViewModel"

class MakeUpViewModel: ObservableObject{
    init() {
        fetchMakeUpData()
    }
    
    @Published var makeUpData: [MakeUpItem] = []
    
    func fetchMakeUpData(){
        FeedClient.shared.fetchMyMakeUpData{
            makeUpData in
            Logger().d(tag:TAG,message: "fetchMakeupData: \(makeUpData)")
             self.makeUpData = makeUpData
        }
    }
    
}
