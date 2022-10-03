package com.app.brubankmovieapp.popularList

//creo mi metodo Onclick para indicar que al presionar en una pelicula, cambie a la vista donde muesta la sinopsis de la pelicula
interface PopularClickListener {
    fun onCLick(movieId: String?)
}