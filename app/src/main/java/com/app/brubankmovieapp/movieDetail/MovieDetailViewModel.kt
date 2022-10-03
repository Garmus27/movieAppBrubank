package com.app.brubankmovieapp.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.brubankmovieapp.models.Movie
import com.app.brubankmovieapp.models.MovieResponse
import com.app.brubankmovieapp.services.services.MovieService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel (val id: Int) : ViewModel(){

    private var _movieDetailLiveData = MutableLiveData<Movie>()

    val movieDetailLiveData: LiveData<Movie>
        get() = _movieDetailLiveData

    init {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                val response = MovieService.getMovieDetail(id)
                _movieDetailLiveData.postValue(response)
            }

        }
    }


}