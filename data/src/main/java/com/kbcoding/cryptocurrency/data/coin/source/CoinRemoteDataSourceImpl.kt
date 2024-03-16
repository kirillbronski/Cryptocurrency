package com.kbcoding.cryptocurrency.data.coins.source

import com.kbcoding.cryptocurrency.api.CoinPaprikaApi
import com.kbcoding.cryptocurrency.mappers.toCoinDetail
import com.kbcoding.cryptocurrency.model.CoinDetail
import javax.inject.Inject

class CoinRemoteDataSourceImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRemoteDataSource  {
    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }

}