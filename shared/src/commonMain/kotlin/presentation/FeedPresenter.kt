package presentation

import domain.FeedData
import domain.GetFeedData
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import platform.Logger

private const val TAG = "FeedPresenter"

class FeedPresenter(private val feed: GetFeedData) {
   fun fetchAllMakeUpData(cb: FeedData) {
        Logger.d(TAG, "fetchAllMakeUpData")
        MainScope().launch {
            feed.invokeGetMyMakeUpData(
                onSuccess = { cb.onMyMakeUpData(it) },
                onFailure = { cb.onMyMakeUpData(emptyList()) }
            )
        }

    }
}