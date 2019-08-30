package com.example.rest.userapi.transfer

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
class UserTO (

		@Size(max=30)
		var login: String,
		@Size(max=30)
		var firstname: String,
		@Size(max=30)
		var lastname: String,
		@Size(max=30)
		var description: String? = null,
		var id: String? = null

)
