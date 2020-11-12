package com.example.android_example.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    init {
        Log.i("ViewModel", "DetailsViewModel created!")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "DetailsViewModel destroyed!")
    }
}