package com.example.keepitchecked.ui.home

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.security.AccessControlContext
import java.util.prefs.Preferences

class HomeViewModel : ViewModel() {
    var et_name: String = ""
    var rb_mood: String = ""

    fun set_name(name: String) {
        this.et_name = name;
    }
    fun get_name(): String {
        return this.et_name
    }
    fun set_mood(mood: String) {
        this.rb_mood = mood
    }
    fun get_mood(): String {
        return this.rb_mood
    }

    /*private val _text = MutableLiveData<String>().apply {
        value = "🎊 Welcome to the Keep It 🎊 Checked App!"
    }
    val text: LiveData<String> = _text*/

}