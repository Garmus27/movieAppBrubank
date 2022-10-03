package com.app.brubankmovieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(@SerializedName(value = "id")
                 val id: String?,

                 @SerializedName(value="title")
                 val title:String?,

                 @SerializedName(value = "overview")
                 val description: String?,

                 @SerializedName(value = "poster_path")
                 val portada_path:String?,

                 @SerializedName(value = "genres")
                 val generos : List<Genero>
) : Parcelable {




}