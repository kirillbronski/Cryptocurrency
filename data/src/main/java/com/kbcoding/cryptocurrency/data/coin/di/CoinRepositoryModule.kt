package com.kbcoding.cryptocurrency.data.coin.di

import com.kbcoding.cryptocurrency.data.coins.domain.repository.CoinDataRepository
import com.kbcoding.cryptocurrency.data.coins.repository.CoinDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinRepositoryModule {

    @Binds
    @Singleton
    fun bindCoinDataRepository(repository: CoinDataRepositoryImpl): CoinDataRepository
}