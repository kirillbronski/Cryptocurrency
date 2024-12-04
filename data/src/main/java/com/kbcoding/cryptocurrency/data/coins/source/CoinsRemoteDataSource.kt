package com.kbcoding.cryptocurrency.data.coins.source

import com.kbcoding.cryptocurrency.api.CoinPaprikaApi
import com.kbcoding.cryptocurrency.mappers.toCoin
import com.kbcoding.cryptocurrency.model.Coin
import javax.inject.Inject

class CoinsRemoteDataSource @Inject constructor(
    private val api: CoinPaprikaApi
) {

    suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }
}