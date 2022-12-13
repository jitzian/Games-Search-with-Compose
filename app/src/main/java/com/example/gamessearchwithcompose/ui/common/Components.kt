package com.example.gamessearchwithcompose.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.example.gamessearchwithcompose.R

@Composable
fun AppDivider(
    verticalPadding: Dp
) {
    Divider(
        color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
        thickness = dimensionResource(id = R.dimen.dimen_1_dp),
        startIndent = dimensionResource(id = R.dimen.dimen_0_dp),
        modifier = Modifier.padding(vertical = verticalPadding)
    )
}