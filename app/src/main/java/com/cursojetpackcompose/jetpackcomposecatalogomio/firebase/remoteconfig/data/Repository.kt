package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.data

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class Repository @Inject constructor(val remoteConfig: FirebaseRemoteConfig){

    companion object{
        const val TITLE_RC = "title"
        const val SHOWTEXT_RC = "showText"
    }
    suspend fun getAppInfo(): AppInfoText{
        remoteConfig.fetch(0)
        remoteConfig.activate().await()//incluir await en el activate para que no se bloquee la app
        val title = remoteConfig.getString(TITLE_RC)
        val showText = remoteConfig.getBoolean(SHOWTEXT_RC)
        return  AppInfoText(title, showText)
    }
}

data class AppInfoText (val title: String, val showText: Boolean)