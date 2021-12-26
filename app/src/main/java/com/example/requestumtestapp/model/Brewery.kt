package com.example.requestumtestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Brewery(
    @PrimaryKey(autoGenerate = true)
    val mId: Int,

    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id : String? = null,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String? = null,

    @ColumnInfo(name = "brewery_type")
    @SerializedName("brewery_type")
    var breweryType    : String? = null,

    @ColumnInfo(name = "street")
    @SerializedName("street")
    var street: String? = null,
    @ColumnInfo(name = "address_2")
    @SerializedName("address_2")
    var address2: String? = null,

    @ColumnInfo(name = "address_3")
    @SerializedName("address_3")
    var address3: String? = null,

    @ColumnInfo(name = "city")
    @SerializedName("city")
    var city: String? = null,

    @ColumnInfo(name = "state")
    @SerializedName("state")
    var state: String? = null,

    @ColumnInfo(name = "county_province")
    @SerializedName("county_province")
    var countyProvince : String? = null,

    @ColumnInfo(name = "postal_code")
    @SerializedName("postal_code")
    var postalCode: String? = null,

    @ColumnInfo(name = "country")
    @SerializedName("country")
    var country: String? = null,

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    var longitude: String? = null,

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    var latitude: String? = null,

    @ColumnInfo(name ="phone")
    @SerializedName("phone")
    var phone: String? = null,

    @ColumnInfo(name = "website_url")
    @SerializedName("website_url")
    var websiteUrl: String? = null,

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    var createdAt: String? = null

){

}
