package com.kbcoding.cryptocurrency.data.coin.di

import com.kbcoding.cryptocurrency.data.coins.source.CoinRemoteDataSource
import com.kbcoding.cryptocurrency.data.coins.source.CoinRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinSourceModule {

    @Binds
    @Singleton
    fun bindCoinSource(dataSource: CoinRemoteDataSourceImpl): CoinRemoteDataSource
}