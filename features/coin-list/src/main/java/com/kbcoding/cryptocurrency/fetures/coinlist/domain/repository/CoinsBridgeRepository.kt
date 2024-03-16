package com.kbcoding.cryptocurrency.fetures.coinlist.domain.repository

import com.kbcoding.cryptocurrency.model.Coin

interface CoinsBridgeRepository {

    suspend fun getCoins(): List<Coin>

}