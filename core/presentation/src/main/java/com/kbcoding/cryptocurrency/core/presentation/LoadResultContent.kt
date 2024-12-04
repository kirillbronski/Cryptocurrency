package com.kbcoding.cryptocurrency.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kbcoding.cryptocurrency.core.common.Resource

@Composable
fun <T> ResourceContent(
    screenState: Resource<T>,
    content: @Composable (T) -> Unit,
    modifier: Modifier = Modifier,
    error: @Composable (String) -> Unit = {},
) {

    when (screenState) {
        is Resource.Loading -> Box(modifier = modifier) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        is Resource.Success -> content(screenState.data)

        is Resource.Error -> error(screenState.message)
    }
}