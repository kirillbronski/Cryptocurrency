package com.kbcoding.cryptocurrency.domain.repository

import com.kbcoding.cryptocurrency.model.Coin
import com.kbcoding.cryptocurrency.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail
}