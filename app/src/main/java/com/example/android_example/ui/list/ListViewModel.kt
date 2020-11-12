package com.example.android_example.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ListViewModel : ViewModel() {

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var job: Job? = null
    val sec = MutableLiveData<Int>()

    fun getAllMovies(){
        job?.cancel()
        job = scope.launch {
            for(i in 1..100){
                sec.value = i
                delay(1000)
            }
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