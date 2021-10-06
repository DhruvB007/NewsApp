package com.subhag.inshortsclone.di

import com.subhag.api.services.harperdb.HarperDbUserApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesHarperAuthClient(harperAuthClient: HarperDbUserApiClient) = harperAuthClient

}