package com.subhag.api.services.harperdb

import com.subhag.api.models.dto.UserDTO

class SQLHelper {

    companion object {

        fun getSQLCommandForGetUser(email: String): HarperDbSqlModel {
            return HarperDbSqlModel("SELECT * FROM taskify.user WHERE email = '${email}' LIMIT 1")
        }

        fun getSQLCommandForStoringUser(userDTO: UserDTO): HarperDbSqlModel {
            return HarperDbSqlModel(
                "INSERT INTO taskify.user (username,email, profile_img) "
                        + "VALUE ('${userDTO.username}','${userDTO.email}','${userDTO.profile_img}')"
            )
        }

    }
}