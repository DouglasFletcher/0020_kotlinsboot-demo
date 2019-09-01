package com.example.rest.userapi.transfer

import javax.validation.constraints.Size

/**
 * user data transfer object
 */
class UserTO (
    @Size(max=30)
    var username: String = "",
    @Size(max=30)
    var firstname: String = "",
    @Size(max=30)
    var lastname: String = "",
    @Size(max=30)
    var description: String? = null,
    var id: String? = null
)
