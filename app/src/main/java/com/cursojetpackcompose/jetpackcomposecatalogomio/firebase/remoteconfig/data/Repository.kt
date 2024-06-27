package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.data

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class Repository @Inject constructor(val remoteConfig: FirebaseRemoteConfig){

    companion object{
        const val TITLE_RC = "title"
        const val HAPPY_RC = "happy"
    }
    suspend fun getAppInfo(): String{
        remoteConfig.fetch(0)
        remoteConfig.activate().await()//incluir await en el activate para que no se bloquee la app
        val title = remoteConfig.getString(TITLE_RC)
        val happy = remoteConfig.getBoolean(HAPPY_RC)
        return "El titulo de RemoteConfig es: $title y la aplicacion está ${if(happy) "feliz" else "triste"}"
    }
}