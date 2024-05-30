package com.cursojetpackcompose.jetpackcomposecatalogomio.components.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComponentesViewModel @Inject constructor() : ViewModel() {

    private val _myText = MutableLiveData<String>()
    val mytext: LiveData<String> = _myText

    private val _myTextOutlined = MutableLiveData<String>()
    val mytextOutlined: LiveData<String> = _myTextOutlined

    fun setMyText(myText: String, myTextOutlined: String) {
        _myText.value = myText
        _myTextOutlined.value = myTextOutlined
    }



}