package com.example.rest.base.messages

import java.io.IOException
import java.util.*

enum class UserMessages private constructor(private val propertyKey: String) {
    userNotFound("user.not.found"); //NOSONAR
}