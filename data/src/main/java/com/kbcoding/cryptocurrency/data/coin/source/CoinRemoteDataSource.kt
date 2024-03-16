package com.kbcoding.cryptocurrency.data.coins.source

import com.kbcoding.cryptocurrency.model.CoinDetail

interface CoinRemoteDataSource {

    suspend fun getCoinById(coinId: String): CoinDetail
}