package com.kbcoding.cryptocurrency.data.coins.domain.repository

import com.kbcoding.cryptocurrency.model.CoinDetail

interface CoinDataRepository {

    suspend fun getCoinById(coinId: String): CoinDetail

}