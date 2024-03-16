package com.kbcoding.cryptocurrency.data.coins.repository


import com.kbcoding.cryptocurrency.data.coins.domain.repository.CoinsDataRepository
import com.kbcoding.cryptocurrency.data.coins.source.CoinsRemoteDataSource
import com.kbcoding.cryptocurrency.model.Coin
import javax.inject.Inject

class CoinsDataRepositoryImpl @Inject constructor(
    private val dataSource: CoinsRemoteDataSource
) : CoinsDataRepository {
    override suspend fun getCoins(): List<Coin> {
        return dataSource.getCoins()
    }


}