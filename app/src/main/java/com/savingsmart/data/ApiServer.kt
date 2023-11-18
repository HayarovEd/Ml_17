package com.savingsmart.data

import com.savingsmart.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("532/db.json")
    suspend fun getDataDb () : BaseDto
}