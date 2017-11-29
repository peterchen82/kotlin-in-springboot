package com.github.peterchen82.repository

import com.github.peterchen82.entity.Account
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<Account, String> {
    fun findByName(name: String): Iterable<Account>
}