package com.example.data.network.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.data.BuildConfig

class ApiClient private constructor() {
    val api: ApiService
        get() = retrofit!!.create(
            ApiService::class.java
        )

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }).build()
        ).build()
    }


    companion object {
        private const val BASE_URL = "https://api.kinopoisk.dev/"
        private var apiClient: ApiClient? = null
        private var retrofit: Retrofit? = null

        val instanse: ApiClient?
            @Synchronized get() {
                if (apiClient == null) {
                    apiClient = ApiClient()
                }
                return apiClient
            }
    }
}