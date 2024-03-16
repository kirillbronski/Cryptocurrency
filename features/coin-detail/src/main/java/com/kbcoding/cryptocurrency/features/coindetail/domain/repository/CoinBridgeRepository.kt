package com.kbcoding.cryptocurrency.features.coindetail.domain.repository

import com.kbcoding.cryptocurrency.model.CoinDetail

interface CoinBridgeRepository {

    suspend fun getCoinById(coinId: String): CoinDetail
}