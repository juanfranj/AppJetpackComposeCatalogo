package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.data.AppInfoText
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.data.Repository
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.domain.CanAccessToApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RemoteConfigViewModel @Inject constructor(val repository: Repository, private val canAccessToApp: CanAccessToApp) : ViewModel() {

    private val _appInfoText = MutableLiveData<AppInfoText>()
    val appInfoText: LiveData<AppInfoText> = _appInfoText

    private val _showBlockDialog = MutableStateFlow<Boolean?>(null)
    val showBlockDialog: StateFlow<Boolean?> = _showBlockDialog

    fun initApp() {
        viewModelScope.launch(Dispatchers.IO) {
//            _texto.postValue(repository.getAppInfo()) Si quiero actualizar en un hilo de fondo sin withContext
            val response = repository.getAppInfo()
            //Los cambios de ui se tienen que hacer en el hilo principal, por lo que hacemos el cambio
            //con un withContext(Dispatchers.Main)
            withContext(Dispatchers.Main) {
                _appInfoText.value = response
            }
//            Log.i("juanfran", "initApp: ${response}")
        }
        viewModelScope.launch {
           val canAccess = withContext(Dispatchers.IO) {
               canAccessToApp()
           }
            Log.i("juanfran", "Pued iniciar la app: $canAccess")
            _showBlockDialog.value = !canAccess
        }

    }
    fun closeDialog() {
        _showBlockDialog.value = !_showBlockDialog.value!!
    }
}