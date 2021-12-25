package com.example.requestumtestapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const val baseUrl = "https://api.openbrewerydb.org/"

        private fun getClient(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getRetrofitService(): BreweryApi {
            return getClient().create(BreweryApi::class.java)
        }
    }
}