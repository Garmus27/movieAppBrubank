package com.app.brubankmovieapp.popularList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.app.brubankmovieapp.R
import com.app.brubankmovieapp.models.Movie

//creo el adapter
class PopularAdapter(val list: List<Movie>, val listener: PopularClickListener): Adapter<PopularViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return PopularViewHolder(layoutInflater.inflate(R.layout.card_layout,parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount(): Int = list.size
}