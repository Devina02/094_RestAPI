package com.example.pam9.service_api

import com.example.pam9.model.Kontak
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("kontak")
    suspend fun getKontak(): List<Kontak>

    @GET("kontak/{id}")
    suspend fun getKontakById(@Path("id") id:Int): Kontak

    @POST("kontak")
    suspend fun insertKontak(@Body kontak: Kontak)

    @PUT("kontak/{id}")
    suspend fun updateKontak(@Path("id") id: Int, @Body kontak: Kontak)

    @DELETE("kontak/{id}")
    suspend fun deletekontak(@Path("id") id: Int): Response<Void>
}