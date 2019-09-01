package com.example.rest.userapi.exceptions

import com.example.rest.base.exceptions.DomainServiceException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Cannot find login exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class CannotFindLoginException(message: String): DomainServiceException(message) {

    companion object {
        private val serialVersionUID = -944063674606790802L
    }
}