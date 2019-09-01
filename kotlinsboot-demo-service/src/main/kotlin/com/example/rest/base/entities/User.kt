package com.example.rest.base.entities

import org.hibernate.annotations.GenericGenerator
import org.springframework.lang.Nullable
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

/**
 * user database entity
 */
@Entity
@Table(name="User")
class User(
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name="system-uuid", strategy = "uuid")
        var id: String? = null,
        var login: String  = "",
        var firstname: String = "",
        var lastname: String = "",
        var description: String? = null
)

