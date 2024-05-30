package com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.data.network

import com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/6dc67c8c-256b-4af1-9883-7703fafe04fe")
    suspend fun doLogin(): Response<LoginResponse>
}