package com.example.swiftycompanion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    val user: MutableLiveData< Map<String, *> > by lazy {
        MutableLiveData< Map<String, *> >().also {
            loadUser()
        }
    }

    fun getUser(): LiveData< Map<String, *> > {
        return user
    }

    private fun loadUser() {

    }
}