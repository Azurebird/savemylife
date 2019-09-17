package com.example.savemylife.repository.service

import retrofit2.http.GET
import retrofit2.http.Path

interface AlertService {

    @GET("/bot-sensoresCAWR.php?ubicacionX={xCoord}&ubicacionY={yCoord}&celular={phone}&codigo={code}")
    fun alert(
        @Path("xCoord") xCoord: String,
        @Path("yCoord") yCoord: String,
        @Path("phone") phone: String,
        @Path("code") code: String)
}
