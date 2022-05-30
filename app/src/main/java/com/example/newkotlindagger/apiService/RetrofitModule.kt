package com.example.newkotlindagger.apiService

import com.example.newkotlindagger.apiService.ApiService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)
}
