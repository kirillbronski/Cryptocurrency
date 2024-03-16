package com.bronski.cryptocurrency.featureBridge.coins

import com.kbcoding.cryptocurrency.data.coins.domain.repository.CoinsDataRepository
import com.kbcoding.cryptocurrency.fetures.coinlist.domain.repository.CoinsBridgeRepository
import com.kbcoding.cryptocurrency.model.Coin
import javax.inject.Inject

class CoinsBridgeRepositoryImpl @Inject constructor(
    private val repository: CoinsDataRepository
) : CoinsBridgeRepository {
    override suspend fun getCoins(): List<Coin> {
        return repository.getCoins()
    }
}