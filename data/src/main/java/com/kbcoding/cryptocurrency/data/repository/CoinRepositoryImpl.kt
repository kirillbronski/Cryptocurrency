package com.kbcoding.cryptocurrency.data.repository


import com.kbcoding.cryptocurrency.api.CoinPaprikaApi
import com.kbcoding.cryptocurrency.api.dto.CoinDetailDto
import com.kbcoding.cryptocurrency.api.dto.CoinDto
import com.kbcoding.cryptocurrency.domain.repository.CoinRepository
import com.kbcoding.cryptocurrency.mappers.toCoin
import com.kbcoding.cryptocurrency.mappers.toCoinDetail
import com.kbcoding.cryptocurrency.model.Coin
import com.kbcoding.cryptocurrency.model.CoinDetail
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }
}