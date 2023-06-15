package ge.neirondev.makeup.android.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import data.model.MakeUpItem

@Composable
fun MakeUpScreen(
    feedViewModel: FeedViewModel
) {
    val makeUpList = feedViewModel.makeUpList.observeAsState()
    LaunchedEffect(key1 = Unit) {
        feedViewModel.fetchMyMakeUpData()
    }
    MakeUpItems(makeupItemList = makeUpList.value ?: emptyList())
}

@Composable
private fun MakeUpItems(
    makeupItemList: List<MakeUpItem>
) {
    LazyColumn(
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            top = 16.dp, start = 8.dp, end = 8.dp, bottom = 16.dp
        ),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
    )
    {
        items(
            items = makeupItemList,
            key = { it.id!! }
        ) { makeUpItem ->
            MakeUpItemCard(makeUpItem = makeUpItem, onClick = {})

        }
    }
}