package ge.neirondev.makeup.android.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.ServiceLocator
import data.model.MakeUpItem
import domain.FeedData
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel(), FeedData {

    private val _makeUpList = MutableLiveData<List<MakeUpItem>>()
    val makeUpList: MutableLiveData<List<MakeUpItem>> = _makeUpList

    private val presenter by lazy {
        ServiceLocator.getFeedPresenter
    }
    fun fetchMyMakeUpData() {
        presenter.fetchAllMakeUpData(this)
    }

    override fun onMyMakeUpData(itemList: List<MakeUpItem>) {
        viewModelScope.launch {
            _makeUpList.value = itemList
        }
    }
}