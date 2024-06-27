package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.data

import android.content.Context
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class Repository @Inject constructor(
    private val remoteConfig: FirebaseRemoteConfig,
    @ApplicationContext private val context: Context
) {

    companion object {
        const val TITLE_RC = "title"
        const val SHOWTEXT_RC = "showText"
        const val MIN_VERSION_RC = "min_version"
    }

    suspend fun getAppInfo(): AppInfoText {
        remoteConfig.fetch(0)
        remoteConfig.activate().await()//incluir await en el activate para que no se bloquee la app
        val title = remoteConfig.getString(TITLE_RC)
        val showText = remoteConfig.getBoolean(SHOWTEXT_RC)
        return AppInfoText(title, showText)
    }

    fun getAppVersion(): List<Int> {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.versionName.split(".").map { it.toInt() }
        } catch (e: Exception) {
            listOf(0, 0, 0)
        }
    }
    suspend fun getMinAllowedVersion(): List<Int> {
        remoteConfig.fetch(0)
        remoteConfig.activate().await()//incluir await en el activate para que no se bloquee la app
        val minVersion = remoteConfig.getString(MIN_VERSION_RC)
        if(minVersion.isBlank()) return listOf(0,0,0)
        return minVersion.split(".").map { it.toInt() }

    }
}

data class AppInfoText(val title: String, val showText: Boolean)