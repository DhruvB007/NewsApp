package com.subhag.api

import com.subhag.api.models.dto.UserDTO
import com.subhag.api.models.mapper.UserMapper
import com.subhag.api.services.harperdb.HarperDbUserApiClient
import com.subhag.api.services.harperdb.SQLHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class HarperDbUserApiTest {

    private val harperDbUserApi = HarperDbUserApiClient().harperUserApi
    private val userMapper = UserMapper()

    @Test
    fun `Test GET UserInfo`() {
        runBlocking {
            val sqlCommand = SQLHelper.getSQLCommandForGetUser("subhag777@outlook.com")
            val userResponse = harperDbUserApi.getUsers(sqlCommand)
            val user = userMapper.toDomainModel(userResponse.body()!!.first())
            assertEquals(userResponse.isSuccessful, true)
            assertEquals(user.username, "Subhag")
            assertEquals(user.email, "subhag777@outlook.com")
        }
    }

    @Test
    fun `Test Persist User On Backend`() {
        runBlocking {
            val testUser = UserDTO("abc123", "abc@d.com", "asdfasdf")
            val sqlCommand = SQLHelper.getSQLCommandForStoringUser(testUser)
            val addUserResponse = harperDbUserApi.persistUserOnBackend(sqlCommand)
            assertEquals(addUserResponse.isSuccessful, true)
        }
    }

}