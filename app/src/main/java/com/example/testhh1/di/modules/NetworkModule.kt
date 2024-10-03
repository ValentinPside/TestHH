package com.example.testhh1.di.modules

import com.example.testhh1.BuildConfig
import com.example.testhh1.data.network.NetworkServiceAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Provides
    fun provideDefaultClient(): OkHttpClient = OkHttpClient()
        .newBuilder()
        .apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                )
            }
        }
        .build()

    @Provides
    fun provideRetrofit(defaultClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://drive.usercontent.google.com/")
        .client(defaultClient)
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): NetworkServiceAPI =
        retrofit.create(NetworkServiceAPI::class.java)

}