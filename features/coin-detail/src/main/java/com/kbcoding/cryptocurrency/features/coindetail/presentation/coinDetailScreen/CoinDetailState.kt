package com.kbcoding.cryptocurrency.features.coindetail.presentation.coinDetailScreen

import com.kbcoding.cryptocurrency.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
