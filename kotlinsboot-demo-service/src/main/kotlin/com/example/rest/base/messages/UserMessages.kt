package com.example.rest.base.messages

import java.lang.RuntimeException
import java.util.*

/**
 * static messages
 */
enum class UserMessages(private val propertyKey: String){

    // all messages
    userNotFound("user.not.found"), //NOSONAR
    ;

    var value: String=""

    /**
     * get all user messages
     */
    companion object {
        init {
            val props = Properties()
            try {
                val input = Thread.currentThread()
                        .contextClassLoader
                        .getResourceAsStream("userMessages.properties")
                props.load(input)
            } catch (ex: Exception){
                throw RuntimeException("Could not load property file.", ex)
            }
            for(message in UserMessages.values()){
                val value = props.getProperty(message.propertyKey)
                if (value.isNullOrEmpty()){
                    throw RuntimeException("Property <" + message.propertyKey + "> not found in file.")
                }
                message.value = value
            }
        }
    }

    /**
     * format message with arguments
     * @args value to replace
     */
    fun format(vararg args: Any): String {
        return String.format(propertyKey, args)
    }

    /**
     * to string value
     */
    override fun toString(): String {
        return value
    }

}
