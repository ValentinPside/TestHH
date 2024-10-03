package com.example.testhh1.data.network

import com.example.testhh1.data.network.dto.ResponseDto
import retrofit2.http.GET

interface NetworkServiceAPI {

    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download ")
    suspend fun getCardDto(): ResponseDto

}