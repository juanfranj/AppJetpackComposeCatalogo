package com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.data.network

import com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.core.network.RetrofitHelper_Borrar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {
//    private val retrofit = RetrofitHelper_Borrar.getRetrofit()

    suspend fun doLogin(user: String, password: String):Boolean{

        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }

    }
}