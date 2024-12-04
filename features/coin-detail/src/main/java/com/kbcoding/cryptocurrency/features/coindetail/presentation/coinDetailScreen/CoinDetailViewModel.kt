package com.kbcoding.cryptocurrency.features.coindetail.presentation.coinDetailScreen

import androidx.lifecycle.viewModelScope
import com.kbcoding.cryptocurrency.core.common.map
import com.kbcoding.cryptocurrency.core.presentation.BaseViewModel
import com.kbcoding.cryptocurrency.features.coindetail.domain.useCase.GetCoinUseCase
import com.kbcoding.cryptocurrency.model.CoinDetail
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel(assistedFactory = CoinDetailViewModel.Factory::class)
class CoinDetailViewModel @AssistedInject constructor(
    @Assisted private val coinId: String,
    private val getCoinUseCase: GetCoinUseCase,
) : BaseViewModel<CoinDetailViewModel.ScreenState>() {

    init {
        getCoin(coinId)
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            handleResult(result.map { coin ->
                ScreenState(coinDetail = coin)
            })
        }.launchIn(viewModelScope)
    }

    data class ScreenState(
        val coinDetail: CoinDetail
    )

    @AssistedFactory
    interface Factory {
        fun create(index: String): CoinDetailViewModel
    }

}