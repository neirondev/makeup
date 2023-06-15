//
//  FeedClient.swift
//  iosApp
//
//  Created by denis on 08.06.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


public class FeedClient{
    private init(){}
    
    public typealias MakeUpItemHandler = (_ makeupItems : [MakeUpItem]) -> Void
    private var makeUpItemHandler :MakeUpItemHandler?
    public static let shared = FeedClient()
    
    private let feedPresenter = ServiceLocator.init().getFeedPresenter
    
    public func fetchMyMakeUpData(competeon: @escaping MakeUpItemHandler){
        feedPresenter.fetchAllMakeUpData(cb: self)
    }
}

extension FeedClient:FeedData{
    public func onMyMakeUpData(itemList: [MakeUpItem]) {
        self.makeUpItemHandler
    }
}
