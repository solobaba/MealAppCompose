package com.example.coreuiimpl.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.coreuiimpl.model.response.MealResponse

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    //val scrollState = rememberLazyListState()
    //val offset = kotlin.math.min(1f, 1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex))
    val scrollState = rememberScrollState()
    val offset = kotlin.math.min(1f, 1 - (scrollState.value / 600f))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset), label = "")

    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderWidth by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")

//    var isExpanded by remember { mutableStateOf(false) }
//    val imageSize: Dp by animateDpAsState(
//        targetValue = if (isExpanded) 200.dp else 100.dp, label = "DpAnimation"
//    )

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = CircleShape,
                border = BorderStroke(
                    width = borderWidth,
                    color = color
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = meal?.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    modifier = Modifier.size(size),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 20.dp),
                text = meal?.name ?: "Default name",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 5.dp),
                text = meal?.description ?: "Default description",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
            Button(
                modifier = Modifier.padding(top = 20.dp),
                onClick = {
                    profilePictureState = if (profilePictureState == MealProfilePictureState.Normal)
                        MealProfilePictureState.Expanded
                    else
                        MealProfilePictureState.Normal
                },
                colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
                Text(
                    text = "Change state of meal profile picture",
                    color = Color.White
                )
            }

//            LazyColumn {
//                item(meal?.description) {
//                }
//            }

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(top = 20.dp),
                    text = meal?.description ?: "Default description",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(top = 20.dp),
                    text = meal?.description ?: "Default description",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(top = 20.dp),
                    text = meal?.description ?: "Default description",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(top = 20.dp),
                    text = meal?.description ?: "Default description",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }

}

enum class MealProfilePictureState(
    val color: Color, val size: Dp, val borderWidth: Dp
) {
    Normal(Color.Magenta, 100.dp, 1.dp),
    Expanded(Color.Green, 200.dp, 2.dp)
}