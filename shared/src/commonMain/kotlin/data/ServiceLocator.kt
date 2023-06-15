package data

import domain.GetFeedData
import presentation.FeedPresenter

object ServiceLocator {
private val getFeed:GetFeedData = GetFeedData()
public val getFeedPresenter: FeedPresenter = FeedPresenter(getFeed)

}