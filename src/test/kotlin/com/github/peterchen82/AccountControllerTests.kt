package com.github.peterchen82

import com.github.peterchen82.entity.Account
import com.github.peterchen82.repository.AccountRepository
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.http.ResponseEntity




@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTests {

    @Autowired
    lateinit var rest: TestRestTemplate
    @Autowired
    lateinit var repository: AccountRepository


    @Before
    fun init(){
        println("init test data")
        repository.save(Account("Jack", "jack-password"))
        repository.save(Account("Chloe", "chloe-password"))
        repository.save(Account("Kim", "kim-password"))
        repository.save(Account("David", "david-password"))
    }
    @After
    fun after(){
        println("clean test data")
        repository.deleteAll()
    }
    @Test
    fun testList_shouldReturnFour() {
        val result = rest.getForEntity("/account/list", Array<Account>::class.java)
        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertEquals(result?.body?.size, 4)
    }
}