package com.kbcoding.cryptocurrency.fetures.coinlist.presentation.coinListScreen

import com.kbcoding.cryptocurrency.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
