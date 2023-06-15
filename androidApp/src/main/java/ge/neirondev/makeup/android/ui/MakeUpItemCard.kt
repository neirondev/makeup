package ge.neirondev.makeup.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import data.model.MakeUpItem
import ge.neirondev.makeup.android.R
import java.time.format.TextStyle

@Composable
fun MakeUpItemCard(
    makeUpItem: MakeUpItem,
    onClick: (MakeUpItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = { onClick(makeUpItem) }),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = makeUpItem.image_link,
                modifier = Modifier.size(200.dp)
                .fillMaxWidth(),
                //.wrapContentHeight(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = makeUpItem.name.orEmpty(),
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .width(80.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = makeUpItem.brand.orEmpty(),
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .width(80.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = makeUpItem.price.orEmpty(),
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .width(80.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
@Preview
@Composable
fun PreviewMakeUpItem(){
    MakeUpItemCard(makeUpItem = MakeUpItem(1,"brand","name","4","5","6",
        "androidx.core.R.drawable.ic_call_answer","8","9","description",1.1,"12","13",
        null,"15"),onClick = {})
}