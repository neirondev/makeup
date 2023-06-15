//
//  HomeView.swift
//  iosApp
//
//  Created by denis on 14.06.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct HomeView :View{
    
    @EnvironmentObject private var makeUpViewModel :MakeUpViewModel
    
    
    var body: some View{
        let content =  makeUpViewModel.makeUpData//etchMakeUpData()
    }
}
