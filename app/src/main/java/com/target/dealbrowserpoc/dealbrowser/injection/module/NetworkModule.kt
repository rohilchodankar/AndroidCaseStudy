package com.target.dealbrowserpoc.dealbrowser.injection.module

import com.target.dealbrowserpoc.dealbrowser.AppConstants
import com.target.dealbrowserpoc.dealbrowser.BuildConfig
import com.target.dealbrowserpoc.dealbrowser.data.services.DealService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module class NetworkModule {

  @Provides @Singleton internal fun provideOkHttpClient(): OkHttpClient {
    val httpBuilder = OkHttpClient.Builder()
    if (BuildConfig.ENABLE_LOGGING) {
      val httpLoggingInterceptor = HttpLoggingInterceptor()
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      httpBuilder.interceptors().add(httpLoggingInterceptor)
    }
    return httpBuilder.build()
  }

  @Provides @Singleton internal fun provideRestAdapter(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
  }

  @Provides @Singleton internal fun provideApiService(restAdapter: Retrofit): DealService {
    return restAdapter.create(DealService::class.java)
  }
}
