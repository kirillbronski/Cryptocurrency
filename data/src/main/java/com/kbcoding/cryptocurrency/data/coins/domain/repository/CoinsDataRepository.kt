package com.kbcoding.cryptocurrency.data.coins.domain.repository

import com.kbcoding.cryptocurrency.model.Coin

interface CoinsDataRepository {

    suspend fun getCoins(): List<Coin>

}