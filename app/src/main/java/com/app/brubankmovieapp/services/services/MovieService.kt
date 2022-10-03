package com.app.brubankmovieapp.services.services

import com.app.brubankmovieapp.models.Movie
import com.app.brubankmovieapp.models.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieService {
    companion object{
        private const val BASE_URL="https://api.themoviedb.org/3/"
        private var retrofit:Retrofit? = null

        //Creo el objeto retrofit con la Base url y el conversonr de json a gson
        private fun getRetrofit(): Retrofit{
            if (retrofit == null){
                retrofit = Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        //creo el metodo que va a traer el el cuerpo de la respuesta, con los datos que necesito
        suspend fun getMovieList(): MovieResponse? {
            val response = getRetrofit().create(MovieApi::class.java).getMovieList()
            return response.body()
        }


        suspend fun getMovieDetail(id:Int): Movie? {
            val response = getRetrofit().create(MovieApi::class.java).getMovie(id)
            return response.body()
        }
    }
}