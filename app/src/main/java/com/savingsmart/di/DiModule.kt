package com.savingsmart.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.savingsmart.data.RepositoryAnalyticImpl
import com.savingsmart.data.RepositoryServerImpl
import com.savingsmart.data.ServiceImpl
import com.savingsmart.data.SharedKeeperImpl
import com.savingsmart.domain.RepositoryAnalytic
import com.savingsmart.domain.RepositoryServer
import com.savingsmart.domain.Service
import com.savingsmart.domain.SharedKeeper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKeeper

    @Binds
    @Singleton
    abstract fun bindRepositoryAnalytic(repository: RepositoryAnalyticImpl): RepositoryAnalytic

    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}