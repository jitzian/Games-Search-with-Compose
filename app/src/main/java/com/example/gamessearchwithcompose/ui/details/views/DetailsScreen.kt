package com.example.gamessearchwithcompose.ui.details.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.gamessearchwithcompose.R
import com.example.gamessearchwithcompose.ui.app.UIGamesApp
import com.example.gamessearchwithcompose.ui.common.ErrorScreen
import com.example.gamessearchwithcompose.ui.common.LoadingScreen
import com.example.gamessearchwithcompose.ui.details.viewmodel.DetailsViewModel

@Composable
fun DetailsScreenState(
    id: Int,
    onBackButton: () -> Unit,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val state by detailsViewModel.state.collectAsState()
    detailsViewModel.fetchGameDetailsById(id)

    when (state) {
        is DetailsViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is DetailsViewModel.UIState.Success -> {
            DetailsScreen(
                nameParam = (state as DetailsViewModel.UIState.Success).name,
                deckParam = (state as DetailsViewModel.UIState.Success).deck,
                imageUrlParam = (state as DetailsViewModel.UIState.Success).imageUrl,
                onBackButton = onBackButton
            )
        }
        is DetailsViewModel.UIState.Error -> {
            ErrorScreen(message = (state as DetailsViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun DetailsScreen(
    nameParam: String,
    deckParam: String,
    imageUrlParam: String,
    onBackButton: () -> Unit
) {
    UIGamesApp {
        Scaffold(topBar = {
            /*MainTopBar(
                barTitle = stringResource(id = R.string.details_TEXT),
                showBackButton = true,
                onBackClick = onBackButton
            )*/
        }) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = dimensionResource(id = R.dimen.dimen_16_dp)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8_dp))
                ) {
                    Image(
                        painter = rememberImagePainter(data = imageUrlParam),
                        contentDescription = nameParam,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_4_dp))),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = nameParam,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = deckParam,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevDetailsScreen() {
    DetailsScreen(
        nameParam = "Something about SEGA",
        deckParam = "SEGA AGES 2500 Vol.13: OutRun is a remake of the arcade classic as part of the Sega Ages series. This version was included in the Sega Classics Collection when released in America and Europe.",
        imageUrlParam = "https://www.giantbomb.com/a/uploads/square_avatar/8/84290/2764528-3772727124-44466.jpg"
    ) { /*Empty on purpose*/ }
}