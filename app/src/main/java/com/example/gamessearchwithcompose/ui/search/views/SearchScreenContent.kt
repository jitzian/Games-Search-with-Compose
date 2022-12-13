package com.example.gamessearchwithcompose.ui.search.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.gamessearchwithcompose.R
import com.example.gamessearchwithcompose.data.remote.model.ResultGame

@Composable
fun SearchScreenContent(
    gamesList: List<ResultGame>,
    selectedGameId: (Int) -> Unit,
    closeKeyboard: () -> Unit?
) {
    LazyColumn(
        // This padding helps avoid content going behind the navigation bars.
        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.dimen_48_dp))
    ) {
        items(gamesList) { game ->
            ItemSearchGame(game, selectedGameId, closeKeyboard)
        }
    }
}

@Composable
private fun ItemSearchGame(
    game: ResultGame,
    selectedGameId: (Int) -> Unit,
    closeKeyboard: () -> Unit?
) {
    Text(
        text = game.name.toString(),
        style = MaterialTheme.typography.h6,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    closeKeyboard()
                    selectedGameId(game.id ?: 0)
                }
            )
            .padding(horizontal = 20.dp, vertical = 12.dp)
            .wrapContentWidth(Alignment.Start)
    )
}