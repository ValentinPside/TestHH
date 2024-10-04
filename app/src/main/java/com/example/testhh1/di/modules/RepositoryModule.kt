package com.example.testhh1.di.modules

import com.example.testhh1.data.RepositoryImpl
import com.example.testhh1.domain.Repository
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository = impl

}