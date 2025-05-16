package com.example.memes.di

import com.example.memes.data.repository.MemesRepositoryImpl
import com.example.memes.domain.repository.MemesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun repositoryModule(impl: MemesRepositoryImpl): MemesRepository
}