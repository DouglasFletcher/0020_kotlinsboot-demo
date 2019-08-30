package com.example.rest.userapi.mapper

import com.example.rest.base.entities.User
import com.example.rest.userapi.transfer.UserTO
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface UserConverter {

    @Mapping(source = "username", target = "name")
    fun convertToDto(user: User) : UserTO

    @InheritInverseConfiguration
    fun convertToModel(userTO: UserTO) : User

}

