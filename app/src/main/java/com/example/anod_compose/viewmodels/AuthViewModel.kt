package com.example.anod_compose.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import java.lang.IllegalArgumentException

class AuthViewModel (application: Application) : AndroidViewModel(application) {
    val context = application

    fun initDatabase(type: String, onSuccess: ()-> Unit) {
        Log.d("checkData", "AuthViewModel initDatabase with type: $type")
    }
}

class AuthViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(application = application) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }
}