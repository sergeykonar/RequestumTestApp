package com.example.requestumtestapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.requestumtestapp.R
import com.example.requestumtestapp.model.Brewery

class BreweryAdapter(private val data: ArrayList<Brewery>): RecyclerView.Adapter<BreweryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val country: TextView = itemView.findViewById(R.id.country)
        val state: TextView = itemView.findViewById(R.id.state)
        val city: TextView = itemView.findViewById(R.id.city)
        val street: TextView = itemView.findViewById(R.id.street)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brewery_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreweryAdapter.ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.country.text = data[position].country
        holder.state.text = data[position].state
        holder.city.text = data[position].city
        holder.street.text = data[position].street
    }

    override fun getItemCount(): Int {
        return data.size
    }
}