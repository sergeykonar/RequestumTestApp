package com.example.requestumtestapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.requestumtestapp.adapter.BreweryAdapter
import com.example.requestumtestapp.interfaces.MapCallback
import com.example.requestumtestapp.model.Brewery
import com.example.requestumtestapp.viewmodel.MainViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var breweryList: ArrayList<Brewery>
    private lateinit var breweryListView: RecyclerView
    private lateinit var searchView: EditText
    private val TAG = MainActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        subscribeObserver()
    }

    private fun initViews(){
        breweryListView = findViewById(R.id.breweriesList)
        searchView = findViewById(R.id.searchEditText)

        searchView.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                val query = p0.toString()
                mainViewModel.search(query)
            }

        })
    }

    private fun subscribeObserver(){
        mainViewModel.observeBreweries().observe(this,
            {
                if(it.isNotEmpty()){
                    breweryList = it as ArrayList<Brewery>
                    val adapter = BreweryAdapter(breweryList, object : MapCallback{
                        override fun onCallback(intent: Intent) {
                            startActivity(intent)
                        }

                    })
                    breweryListView.adapter = adapter
                    breweryListView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

                    Log.d(TAG, "Data retrieved!")
                }
            })
    }
}