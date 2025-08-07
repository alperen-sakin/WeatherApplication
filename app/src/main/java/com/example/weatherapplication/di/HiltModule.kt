package com.example.weatherapplication.di

import com.example.weatherapplication.data.repository.CityRepositoryImpl
import com.example.weatherapplication.data.repository.WeatherRepositoryImpl
import com.example.weatherapplication.data.source.remote.WeatherApi
import com.example.weatherapplication.domain.repository.CityRepository
import com.example.weatherapplication.domain.repository.WeatherRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModule {

    @Binds
    @Singleton
    abstract fun bindCityRepository(
        cityRepositoryImpl: CityRepositoryImpl

    ): CityRepository

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    companion object {
        @Provides
        @Singleton
        fun provideMoshi(): Moshi {
            return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(moshi: Moshi): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        @Provides
        @Singleton
        fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
            return retrofit.create(WeatherApi::class.java)
        }
    }
}
