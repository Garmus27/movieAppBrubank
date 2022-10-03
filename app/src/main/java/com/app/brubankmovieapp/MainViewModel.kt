package com.app.brubankmovieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.brubankmovieapp.models.MovieResponse
import com.app.brubankmovieapp.services.services.MovieService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// creo el viewModel para conservar datos al cambiar de vista
class MainViewModel: ViewModel() {

    private var _movieLiveData = MutableLiveData<MovieResponse>()

    val movieLiveData: LiveData<MovieResponse>
        get() = _movieLiveData

    init {
        // implemento coroutins, si todo se realiza en el main thread, puede fallar la aplicacion.
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                val response = MovieService.getMovieList()
                _movieLiveData.postValue(response)
            }

        }
    }
}