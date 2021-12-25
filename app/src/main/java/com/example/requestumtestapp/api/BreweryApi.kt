package com.example.requestumtestapp.api

import com.example.requestumtestapp.model.Brewery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryApi {

    @GET("breweries")
    fun getBreweries(): Call<ArrayList<Brewery>>

    @GET("breweries")
    fun getBreweriesByName(@Query("by_name") name: String): Call<ArrayList<Brewery>>

}