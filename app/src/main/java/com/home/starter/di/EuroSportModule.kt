package com.home.starter.di

import com.home.starter.data.repository.EuroSportDataSource
import com.home.starter.data.service.EuroSportService
import com.home.starter.domain.input.EuroSportRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class EuroSportModule {

    @Provides
    fun providesService(): EuroSportService = Retrofit
        .Builder()
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://extendsclass.com/")
        .build()
        .create(EuroSportService::class.java)

    @Provides
    fun providesDataSource(service: EuroSportService): EuroSportRepository = EuroSportDataSource(service)

}