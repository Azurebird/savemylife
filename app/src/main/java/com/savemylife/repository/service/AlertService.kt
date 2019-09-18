package com.savemylife.repository.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlertService {

    @GET("bot-sensoresCAWR.php")
    fun alert(
        @Query("coordx") xCoord: String,
        @Query("coordy") yCoord: String,
        @Query("celular") phone: String,
        @Query("codigo") code: String): Call<Void>
}
