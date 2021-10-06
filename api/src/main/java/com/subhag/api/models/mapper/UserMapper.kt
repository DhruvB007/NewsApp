package com.subhag.api.models.mapper

import com.subhag.api.models.dto.UserDTO
import com.subhag.api.models.entities.UserEntity

class UserMapper : Mapper<UserDTO, UserEntity> {

    override fun toDomainModel(network: UserDTO): UserEntity = UserEntity(
        username = network.username,
        email = network.email,
        profileImage = network.profile_img,
        hasCustomImage = network.profile_img != "",
    )

    override fun toDomainList(network: List<UserDTO>): List<UserEntity> =
        network.map { toDomainModel(it) }

    override fun toServiceModel(domain: UserEntity): UserDTO =
        UserDTO(username = domain.username, email = domain.email, profile_img = domain.profileImage)

}