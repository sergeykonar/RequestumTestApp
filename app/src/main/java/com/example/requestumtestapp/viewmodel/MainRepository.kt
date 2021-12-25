package com.example.requestumtestapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.requestumtestapp.api.BreweryApi
import com.example.requestumtestapp.api.RetrofitClient
import com.example.requestumtestapp.model.Brewery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(application: Application) {

    private val data = MutableLiveData<List<Brewery>>()
    private var list = ArrayList<Brewery>()
    private var searchList = ArrayList<Brewery>()

    private var breweryApi: BreweryApi = RetrofitClient.getRetrofitService()

    private val TAG = MainRepository::class.java.canonicalName

    init {
        initData()
    }

    private fun initData(){
        val call = breweryApi.getBreweries()
        call.enqueue(object : Callback<ArrayList<Brewery>> {
            override fun onResponse(
                call: Call<ArrayList<Brewery>>,
                response: Response<ArrayList<Brewery>>
            ) {
               if (response.isSuccessful){
                   list = response.body()!!
                   data.postValue(list)
               }else{
                   Log.e(TAG, "Error occurred")
               }
            }

            override fun onFailure(call: Call<ArrayList<Brewery>>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }

        })
    }

    fun getData(): MutableLiveData<List<Brewery>> {
        return data
    }

    fun search(query: String) {
        val call = breweryApi.getBreweriesByName(query)
        call.enqueue(object : Callback<ArrayList<Brewery>>{
            override fun onResponse(
                call: Call<ArrayList<Brewery>>,
                response: Response<ArrayList<Brewery>>
            ) {
                if (response.isSuccessful){
                    searchList = response.body()!!
                    data.postValue(searchList)
                    // TODO: Save responses to Room DB
                }
            }

            override fun onFailure(call: Call<ArrayList<Brewery>>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }

        })
    }

}