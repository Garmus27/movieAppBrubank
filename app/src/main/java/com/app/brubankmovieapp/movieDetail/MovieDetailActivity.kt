package com.app.brubankmovieapp.movieDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.app.brubankmovieapp.R
import com.facebook.drawee.view.SimpleDraweeView
//No logre recuperar los datos de la pelicula clickeada para mostrarlos en el DetailActivity
class MovieDetailActivity : AppCompatActivity() {

    private lateinit var portadaDetail : SimpleDraweeView
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movieId = intent.getStringExtra("MOVIE_ID")

        if (movieId != null) {
            viewModel = MovieDetailViewModel(movieId.toInt())
            viewModel.movieDetailLiveData.observe(this, Observer { movie ->

            })
        }




    }
}