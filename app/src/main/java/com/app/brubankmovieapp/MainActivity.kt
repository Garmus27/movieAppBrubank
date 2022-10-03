package com.app.brubankmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.brubankmovieapp.models.Movie
import com.app.brubankmovieapp.movieDetail.MovieDetailActivity
import com.app.brubankmovieapp.popularList.PopularAdapter
import com.app.brubankmovieapp.popularList.PopularClickListener
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {
    //creo el viewModel
    private lateinit var viewModel: MainViewModel
    //creo el Recycler view
    private lateinit var popularRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inicializo Fresco para poder una simpledrawee
        Fresco.initialize(this);
        setContentView(R.layout.activity_main)


        viewModel = MainViewModel()
        // pongo al view model a observar el bindPopularList
        viewModel.movieLiveData.observe(this, Observer { movieReponse ->
            bindPopularList(movieReponse.peliculas)
            // textView.text = movie.title
        })
        //bindeo el popular list
        popularRv = findViewById(R.id.popular_list)
    }

    //creo el bind popularList y le paso el adapter , tambien coloco el onlick para pasar a la vista de la sinopsis
    private fun bindPopularList(list: List<Movie>) {
        val adapter = PopularAdapter(list, object: PopularClickListener {
            override fun onCLick(movieId: String?) {
                val intent = Intent(applicationContext, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE_ID", movieId)
                startActivity(intent)
                //onBackPressed()
            }

        })
        popularRv.layoutManager = LinearLayoutManager(this )
        popularRv.adapter = adapter
    }
}