package com.bronski.cryptocurrency.domain.repository

import com.bronski.cryptocurrency.data.remote.dto.CoinDetailDto
import com.bronski.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}