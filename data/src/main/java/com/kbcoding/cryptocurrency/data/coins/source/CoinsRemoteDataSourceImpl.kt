package com.kbcoding.cryptocurrency.data.coins.source

import com.kbcoding.cryptocurrency.api.CoinPaprikaApi
import com.kbcoding.cryptocurrency.mappers.toCoin
import com.kbcoding.cryptocurrency.model.Coin
import javax.inject.Inject

class CoinsRemoteDataSourceImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinsRemoteDataSource  {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }
}