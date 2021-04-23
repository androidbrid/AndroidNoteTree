package com.jackshi.androidx_kotlin.ui.member

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MemberViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is member Fragment"
    }
    val text: LiveData<String> = _text
}