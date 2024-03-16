package com.kbcoding.cryptocurrency.data.coins.repository


import com.kbcoding.cryptocurrency.data.coins.domain.repository.CoinDataRepository
import com.kbcoding.cryptocurrency.data.coins.source.CoinRemoteDataSource
import com.kbcoding.cryptocurrency.model.CoinDetail
import javax.inject.Inject

class CoinDataRepositoryImpl @Inject constructor(
    private val dataSource: CoinRemoteDataSource
) : CoinDataRepository {

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return dataSource.getCoinById(coinId)
    }
}