package com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.data

import com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {
    //private val api = LoginService()

    suspend fun doLogin(email: String, password: String):Boolean{
        return api.doLogin(email, password)
    }

}