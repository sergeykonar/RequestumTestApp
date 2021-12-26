package com.example.requestumtestapp.adapter

import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.requestumtestapp.R
import com.example.requestumtestapp.model.Brewery
import android.content.Intent
import android.net.Uri
import com.example.requestumtestapp.interfaces.MapCallback
import java.util.*
import kotlin.collections.ArrayList


class BreweryAdapter(private val data: ArrayList<Brewery>, private val mapCallback: MapCallback): RecyclerView.Adapter<BreweryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val country: TextView = itemView.findViewById(R.id.country)
        val state: TextView = itemView.findViewById(R.id.state)
        val city: TextView = itemView.findViewById(R.id.city)
        val street: TextView = itemView.findViewById(R.id.street)
        val webSite: TextView = itemView.findViewById(R.id.webSite)
        val phone: TextView = itemView.findViewById(R.id.phone)
        val mapButton: Button = itemView.findViewById(R.id.showOnMapButton)

        val countryText: TextView = itemView.findViewById(R.id.textCountry)
        val stateText: TextView = itemView.findViewById(R.id.textState)
        val cityText: TextView = itemView.findViewById(R.id.textCity)
        val streetText: TextView = itemView.findViewById(R.id.textStreet)
        val webSiteText: TextView = itemView.findViewById(R.id.textWebSite)
        val phoneText: TextView = itemView.findViewById(R.id.textPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brewery_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreweryAdapter.ViewHolder, position: Int) {
        holder.name.text = data[position].name

        if(data[position].street.isNullOrEmpty()){
            holder.street.visibility = View.GONE
            holder.streetText.visibility = View.GONE
        }else{
            holder.street.text = data[position].street
        }
        if (data[position].city.isNullOrEmpty()){
            holder.city.visibility = View.GONE
            holder.cityText.visibility = View.GONE
        }else{
            holder.city.text = data[position].city
        }
        if (data[position].state.isNullOrEmpty()){
            holder.state.visibility = View.GONE
            holder.stateText.visibility = View.GONE
        }else{
            holder.state.text = data[position].state
        }
        if (data[position].country.isNullOrEmpty()){
            holder.country.visibility = View.GONE
            holder.countryText.visibility = View.GONE
        }else{
            holder.country.text = data[position].country
        }
        if (data[position].phone.isNullOrEmpty()){
            holder.phone.visibility = View.GONE
            holder.phoneText.visibility = View.GONE
        }else{
            holder.phone.text = data[position].phone
        }
        if (data[position].websiteUrl.isNullOrEmpty()){
            holder.webSite.visibility = View.GONE
            holder.webSiteText.visibility = View.GONE
        }else{
            holder.webSite.text = Html.fromHtml(String.format("<a href=\"%s\">%s</a>", data[position].websiteUrl, data[position].websiteUrl))
            holder.webSite.movementMethod = LinkMovementMethod.getInstance()
        }

        if(data[position].street.isNullOrEmpty()
            || data[position].state.isNullOrEmpty()
            || data[position].country.isNullOrEmpty()
        ){
            holder.mapButton.visibility = View.GONE
        }else{
            holder.mapButton.setOnClickListener {
                val uri: String =
                    java.lang.String.format(Locale.ENGLISH, "geo:%s,%s?q=%s,%s()", data[position].latitude, data[position].longitude, data[position].latitude, data[position].longitude)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                mapCallback.onCallback(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}