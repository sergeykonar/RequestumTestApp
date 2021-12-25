package com.example.requestumtestapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.requestumtestapp.model.Brewery

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = MainRepository(application)
    private val data = repository.getData()

    fun observeBreweries(): MutableLiveData<List<Brewery>>{
        return data
    }

    fun search(query: String) {
        repository.search(query)
    }
}