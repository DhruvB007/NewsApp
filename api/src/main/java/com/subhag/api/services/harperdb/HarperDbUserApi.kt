package com.subhag.api.services.harperdb

import com.subhag.api.BASIC_AUTH
import com.subhag.api.models.dto.UserDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface HarperDbUserApi {

    @POST("/")
    suspend fun persistUserOnBackend(
        @Body body: HarperDbSqlModel,
        @Header("Authorization") header: String = BASIC_AUTH,
    ): Response<Any>

    @POST("/")
    suspend fun getUsers(
        @Body sqlModel: HarperDbSqlModel,
        @Header("Authorization") header: String = BASIC_AUTH
    ): Response<List<UserDTO>>

    companion object {

        const val BASE_URL = "https://taskify-cloud-subhag.harperdbcloud.com"

    }

}