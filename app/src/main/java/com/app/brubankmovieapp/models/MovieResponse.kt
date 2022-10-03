package com.app.brubankmovieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieResponse(

    @SerializedName(value = "results")
    val peliculas: List<Movie>


): Parcelable{constructor(): this(mutableListOf())}