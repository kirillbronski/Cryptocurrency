package com.kbcoding.cryptocurrency.fetures.coinlist.presentation.coinListScreen

import androidx.lifecycle.viewModelScope
import com.kbcoding.cryptocurrency.core.common.map
import com.kbcoding.cryptocurrency.core.presentation.BaseViewModel
import com.kbcoding.cryptocurrency.fetures.coinlist.domain.useCase.GetCoinsUseCase
import com.kbcoding.cryptocurrency.fetures.coinlist.presentation.coinListScreen.CoinListViewModel.ScreenState
import com.kbcoding.cryptocurrency.model.Coin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : BaseViewModel<ScreenState>() {

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            handleResult(
                result.map { coins ->
                    ScreenState(coins = coins)
                }
            )
        }.launchIn(viewModelScope)
    }

    data class ScreenState(
        val coins: List<Coin> = emptyList(),
    )

    fun clearList(){
        _stateFlow.update {
            it.map {
                it.copy(coins = emptyList())
            }
        }
    }
}