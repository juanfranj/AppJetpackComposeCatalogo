package com.cursojetpackcompose.jetpackcomposecatalogomio.progressBar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressBarViewmodel @Inject constructor() : ViewModel() {

    private val _progressStatus = MutableStateFlow<Float>(0f)
    val progressStatus: StateFlow<Float> = _progressStatus

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress

    fun startProgress() {
        viewModelScope.launch {
            while (_progressStatus.value <= 1.1f) {
                delay(100)
                if (_progressStatus.value > 1f) {
                    _progressStatus.value = 0.0f
                }
                _progressStatus.value += 0.025f
            }
        }
    }

    fun incrementCircularProgress() {
        viewModelScope.launch {

            if (_progress.value > 1f) {
                _progress.value = 0f
            }
            _progress.value += 0.1f

        }
    }

    fun decrementCircularProgress() {
        viewModelScope.launch {
            _progress.value -= 0.1f
            if (_progress.value <= 0f) {
                _progress.value = 1f
            }

        }
    }
}