package com.kbcoding.cryptocurrency.fetures.coinlist.presentation.coinListScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kbcoding.cryptocurrency.core.common.Resource
import com.kbcoding.cryptocurrency.core.presentation.EventConsumer
import com.kbcoding.cryptocurrency.core.presentation.LocalNavController
import com.kbcoding.cryptocurrency.core.presentation.ResourceContent
import com.kbcoding.cryptocurrency.core.presentation.RouteCoinDetail
import com.kbcoding.cryptocurrency.core.presentation.routeClass
import com.kbcoding.cryptocurrency.fetures.coinlist.presentation.coinListScreen.CoinListViewModel
import com.kbcoding.cryptocurrency.model.Coin

@Composable
fun CoinListScreen() {

    val viewModel: CoinListViewModel = hiltViewModel()
    val navController = LocalNavController.current

    EventConsumer(channel = viewModel.exitChannel) {
        if (navController.currentBackStackEntry.routeClass() == RouteCoinDetail::class) {
            navController.popBackStack()
        }
    }

    val screenState by viewModel.stateFlow.collectAsStateWithLifecycle()

    CoinListContent(
        screenState = screenState,
        onItemClick = { id, name ->
            navController.navigate(RouteCoinDetail(coinId = id, coinName = name))
        }
    )
}

@Composable
fun CoinListContent(
    screenState: Resource<CoinListViewModel.ScreenState>,
    onItemClick: (String, String) -> Unit,
) {

    ResourceContent(
        screenState = screenState,
        content = { currentScreenState ->
            SuccessCoinListContent(
                screenState = currentScreenState,
                onItemClick = { id, name ->
                    onItemClick(id, name)
                }
            )
        },
        error = {
            ErrorCoinListContent(errorMessage = it)
        }
    )

}

@Composable
fun ErrorCoinListContent(
    errorMessage: String
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun SuccessCoinListContent(
    screenState: CoinListViewModel.ScreenState,
    onItemClick: (String, String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(screenState.coins) { coin ->
            CoinListItem(
                coin = coin,
                onItemClick = {
                    onItemClick(coin.id, coin.name)
                }
            )
        }
    }
}

@Preview(showSystemUi = true, name = "Success State")
@Composable
fun PreviewCoinListScreenSuccess() {
    val screenState = Resource.Success(
        CoinListViewModel.ScreenState(
            coins = listOf(
                Coin("1", true, "BTC", 45000, "url_to_image"),
                Coin("2", true, "ETH", 3000, "url_to_image"),
                Coin("3", true, "ADA", 2, "url_to_image")
            )
        )
    )

    CoinListContent(
        screenState = screenState,
        onItemClick = { id, name -> }
    )
}

@Preview(showSystemUi = true, name = "Error State")
@Composable
fun PreviewCoinListScreenError() {
    val screenState = Resource.Error<CoinListViewModel.ScreenState>("Failed to load coins")

    CoinListContent(
        screenState = screenState,
        onItemClick = { id, name -> }
    )
}

@Preview(showSystemUi = true, name = "Loading State")
@Composable
fun PreviewCoinListScreenLoading() {
    val screenState = Resource.Loading<CoinListViewModel.ScreenState>()

    CoinListContent(
        screenState = screenState,
        onItemClick = { id, name -> }
    )
}
