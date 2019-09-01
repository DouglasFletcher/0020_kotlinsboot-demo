package com.example.rest.base.exceptions

/**
 * <h3>Base class DomainService Exceptions</h3>
 */
open class DomainServiceException : RuntimeException {

    private var details: String? = null
    private var code: String? = null

    companion object {
        private val serialVersionUID = 6833363491513844369L
    }

    constructor(message: String) : super(message) {}

}