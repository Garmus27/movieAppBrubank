package com.app.brubankmovieapp.services.services

import com.app.brubankmovieapp.models.Movie
import com.app.brubankmovieapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    //  creo la interfaz y el Get que va a traer la lista de peliculas
    @GET("movie/popular?api_key=f4fcdcb8320818e3dce228f63ac96204")
    //tiene que ser suspend fun porque trabajara de forma asincrona.
    suspend fun getMovieList(): Response<MovieResponse>

    //el metodo no sirve, probe traerme las pelis con el ID pero la llamada esta mal
    @GET("movie/{id}")
    suspend fun getMovie(@Path("id") id:Int): Response<Movie>

}