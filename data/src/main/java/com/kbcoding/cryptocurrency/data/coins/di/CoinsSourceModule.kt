package com.kbcoding.cryptocurrency.data.coins.di

import com.kbcoding.cryptocurrency.data.coins.source.CoinsRemoteDataSource
import com.kbcoding.cryptocurrency.data.coins.source.CoinsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinsSourceModule {

    @Binds
    @Singleton
    fun bindCoinsSource(dataSource: CoinsRemoteDataSourceImpl): CoinsRemoteDataSource
}