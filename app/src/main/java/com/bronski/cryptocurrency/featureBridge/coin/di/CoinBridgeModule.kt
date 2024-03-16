package com.bronski.cryptocurrency.featureBridge.coins.di

import com.bronski.cryptocurrency.featureBridge.coin.CoinBridgeRepositoryImpl
import com.kbcoding.cryptocurrency.features.coindetail.domain.repository.CoinBridgeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinBridgeModule {

    @Binds
    @Singleton
    fun bindCoinBridgeRepository(bridgeRepository: CoinBridgeRepositoryImpl): CoinBridgeRepository
}