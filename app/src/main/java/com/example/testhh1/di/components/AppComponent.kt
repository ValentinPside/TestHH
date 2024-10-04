package com.example.testhh1.di.components

import android.content.Context
import com.example.testhh1.di.modules.NetworkModule
import com.example.testhh1.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent {

    fun searchComponent(): SearchComponent

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}