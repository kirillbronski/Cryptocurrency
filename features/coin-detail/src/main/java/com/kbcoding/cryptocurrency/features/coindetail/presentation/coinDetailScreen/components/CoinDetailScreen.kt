package com.kbcoding.cryptocurrency.features.coindetail.presentation.coinDetailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kbcoding.cryptocurrency.core.common.Resource
import com.kbcoding.cryptocurrency.core.presentation.EventConsumer
import com.kbcoding.cryptocurrency.core.presentation.LocalNavController
import com.kbcoding.cryptocurrency.core.presentation.ResourceContent
import com.kbcoding.cryptocurrency.core.presentation.RouteCoinDetail
import com.kbcoding.cryptocurrency.core.presentation.routeClass
import com.kbcoding.cryptocurrency.features.coindetail.presentation.coinDetailScreen.CoinDetailViewModel

@Composable
fun CoinDetailScreen(
    coinId: String,
) {

    val viewModel = hiltViewModel<CoinDetailViewModel, CoinDetailViewModel.Factory> { factory ->
        factory.create(coinId)
    }

    val navController = LocalNavController.current

    EventConsumer(channel = viewModel.exitChannel) {
        if (navController.currentBackStackEntry.routeClass() == RouteCoinDetail::class) {
            navController.popBackStack()
        }
    }
    val state by viewModel.stateFlow.collectAsStateWithLifecycle()
    CoinDetailContent(state = state)
}

@Composable
fun CoinDetailContent(
    state: Resource<CoinDetailViewModel.ScreenState>,
) {

    ResourceContent(
        screenState = state,
        content = { screenState ->
            SuccessCoinDetailContent(
                screenState = screenState,
            )
        },
        error = {
            ErrorCoinDetailContent(errorMessage = it)
        }
    )
}

@Composable
fun SuccessCoinDetailContent(
    screenState: CoinDetailViewModel.ScreenState,
) {
    screenState.coinDetail.let { coin ->
        LazyColumn(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.weight(8f)
                    )
                    Text(
                        text = if (coin.isActive) "Active" else "Inactive",
                        color = if (coin.isActive) Color.Green else Color.Red,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .align(CenterVertically)
                            .weight(2f)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = coin.description,
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "tags",
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(15.dp))
                com.google.accompanist.flowlayout.FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    coin.tags.forEach { tag ->
                        CoinTag(tag = tag)
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Team members",
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
            items(coin.team) { teamMember ->
                TeamListItem(
                    teamMember = teamMember,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Divider()
            }
        }
    }
}

@Composable
fun ErrorCoinDetailContent(
    errorMessage: String,
) {
    Box(modifier = Modifier.fillMaxSize()) {
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