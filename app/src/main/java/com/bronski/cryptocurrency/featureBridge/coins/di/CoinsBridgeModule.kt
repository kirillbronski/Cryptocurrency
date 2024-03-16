package com.bronski.cryptocurrency.featureBridge.coins.di

import com.bronski.cryptocurrency.featureBridge.coins.CoinsBridgeRepositoryImpl
import com.kbcoding.cryptocurrency.fetures.coinlist.domain.repository.CoinsBridgeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinsBridgeModule {

    @Binds
    @Singleton
    fun bindCoinsBridgeRepository(bridgeRepository: CoinsBridgeRepositoryImpl): CoinsBridgeRepository
}