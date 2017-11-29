package com.github.peterchen82.service

import com.github.peterchen82.entity.Account
import com.github.peterchen82.repository.AccountRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
open class AccountService(var accountRepository: AccountRepository) {

    fun list(): Iterable<Account> = accountRepository.findAll()
    fun findByName(name: String): Iterable<Account> = accountRepository.findByName(name)

    fun save(account: Account) = accountRepository.save(account)


    fun update(id: String, account: Account): Account? {
        if (accountRepository.findById(id).isPresent) {
            account.id = id
            return accountRepository.save(account)
        }
        return null
    }

    fun count(): Long = accountRepository.count()
    fun get(id: String): Optional<Account> = accountRepository.findById(id)
    fun delete(id: String) = accountRepository.deleteById(id)
    fun exist(id: String) = accountRepository.existsById(id)

}