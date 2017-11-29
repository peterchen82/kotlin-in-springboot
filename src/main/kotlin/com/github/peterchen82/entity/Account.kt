package com.github.peterchen82.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Account(
        var name: String = "",
        var password: String = "",
        @Id @GeneratedValue(generator="system-uuid") @GenericGenerator(name="system-uuid", strategy = "uuid")
        var id: String = ""
)