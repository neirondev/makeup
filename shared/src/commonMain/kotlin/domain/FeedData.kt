package domain

import data.model.MakeUpItem

interface FeedData {
    fun onMyMakeUpData(
        itemList: List<MakeUpItem>
    )

}