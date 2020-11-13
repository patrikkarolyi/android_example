package com.example.android_example.ui.list

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_example.data.interactors.MovieInteractor
import com.example.android_example.data.network.model.NetworkMovie
import kotlinx.coroutines.*

class ListViewModel @ViewModelInject constructor(
    private val movieInteractor: MovieInteractor
) : ViewModel() {

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var job: Job? = null
    val movies = MutableLiveData<List<NetworkMovie>>()

    fun getAllMovies() {
        job?.cancel()
        job = scope.launch {
            movies.value = movieInteractor.getMovies()
        }
    }

    init {
        Log.i("ViewModel", "ListViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ListViewModel destroyed!")
    }
}