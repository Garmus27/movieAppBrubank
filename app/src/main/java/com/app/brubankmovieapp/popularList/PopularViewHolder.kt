package com.app.brubankmovieapp.popularList

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.brubankmovieapp.R
import com.app.brubankmovieapp.models.Movie
import com.facebook.drawee.view.SimpleDraweeView

//creo el viewholder
class PopularViewHolder(val view: View): ViewHolder(view) {

    var BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    private var titleTv: TextView
    private var portadaTV:SimpleDraweeView
    private var linearLL:LinearLayout
    private var generoTv:TextView
    private var contaier:CardView

    init {
        titleTv = view.findViewById(R.id.title)
        portadaTV = view.findViewById(R.id.portada)
        linearLL = view.findViewById(R.id.linearLL)
        generoTv = view.findViewById(R.id.genero)
        contaier = view.findViewById(R.id.container)

    }

    fun bind(movie: Movie, listener: PopularClickListener) {
        titleTv.text = movie.title
        portadaTV.setImageURI(BASE_IMAGE_URL + movie.portada_path)
        portadaTV.colorFilter= ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f)})
        //generoTv.text=movie.generos[0].name

        contaier.setOnClickListener { listener.onCLick(movie.id) }
    }

}