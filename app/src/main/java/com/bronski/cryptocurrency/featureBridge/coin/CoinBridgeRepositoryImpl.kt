package com.bronski.cryptocurrency.featureBridge.coin

import com.kbcoding.cryptocurrency.data.coins.domain.repository.CoinDataRepository
import com.kbcoding.cryptocurrency.features.coindetail.domain.repository.CoinBridgeRepository
import com.kbcoding.cryptocurrency.model.CoinDetail
import javax.inject.Inject

class CoinBridgeRepositoryImpl @Inject constructor(
    private val repository: CoinDataRepository
) : CoinBridgeRepository {
    override suspend fun getCoinById(coinId: String): CoinDetail {
        return repository.getCoinById(coinId)
    }
}