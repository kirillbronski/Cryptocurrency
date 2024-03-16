package com.kbcoding.cryptocurrency.data.coins.source

import com.kbcoding.cryptocurrency.model.Coin

interface CoinsRemoteDataSource {

    suspend fun getCoins(): List<Coin>
}