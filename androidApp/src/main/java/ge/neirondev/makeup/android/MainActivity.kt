package ge.neirondev.makeup.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import ge.neirondev.makeup.android.ui.FeedViewModel
import ge.neirondev.makeup.android.ui.MakeUpScreen

class MainActivity : ComponentActivity() {
private val feedViewModel: FeedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedViewModel.fetchMyMakeUpData()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MakeUpScreen(feedViewModel =feedViewModel)

                }
            }
        }
    }
}


