package com.home.starter.data.service

import com.home.starter.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface EuroSportService {

    @GET("api/json-storage/bin/edfefba")
    suspend fun fetch(): Response<DataResponse>
}