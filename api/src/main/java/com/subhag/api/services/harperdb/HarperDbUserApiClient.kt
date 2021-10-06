package com.subhag.api.services.harperdb

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HarperDbUserApiClient {

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(HarperDbUserApi.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val harperUserApi: HarperDbUserApi = retrofit.create(HarperDbUserApi::class.java)

}