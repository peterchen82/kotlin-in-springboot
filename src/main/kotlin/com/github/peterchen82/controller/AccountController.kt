package com.github.peterchen82.controller

import com.github.peterchen82.entity.Account
import com.github.peterchen82.service.AccountService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import java.util.*

@Api(value = "account", description = "账户管理相关的api")
@RestController
@RequestMapping(value = "/account")
class AccountController(val accountService: AccountService) {


    @ApiOperation(value = "创建账户", notes = "创建账户")
    @ApiImplicitParam(name = "account", value = "账户对象", required = true, dataType = "Account")
    @PostMapping("")
    fun add(@RequestBody account: Account): Account {
        account.id = ""
        return accountService.save(account)
    }

    @ApiOperation(value = "更新账户", notes = "更新账户")
    @ApiImplicitParams(
            ApiImplicitParam(name = "id", paramType = "path", value = "用户ID", required = true, dataType = "String"),
            ApiImplicitParam(name = "account", value = "账户对象", required = true, dataType = "Account")
    )
    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody account: Account): Account? {
        return accountService.update(id, account)
    }

    @ApiOperation(value = "获取账户详细信息", notes = "根据id来获取账户详细信息")
    @ApiImplicitParam(name = "id", paramType = "path", value = "账户ID", required = true)
    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Optional<Account> = accountService.get(id)


    @ApiOperation(value = "删除账户", notes = "根据id来指定删除账户")
    @ApiImplicitParam(name = "id", paramType = "path", value = "账户ID", required = true)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = accountService.delete(id)

    @ApiOperation(value = "判断账户是否存在", notes = "根据id判断账户是否存在")
    @ApiImplicitParam(name = "id", paramType = "path", value = "账户ID", required = true)
    @GetMapping("/exist/{id}")
    fun exist(@PathVariable id: String): Boolean = accountService.exist(id)

    @ApiOperation(value = "获取账户数量", notes = "获取所有账户的数量")
    @GetMapping("/count")
    fun count(): Long = accountService.count()

    @ApiOperation(value = "获取账户列表", notes = "获取所有账户")
    @GetMapping("")
    fun list(): Iterable<Account> = accountService.list()

    @ApiOperation(value = "按账户名查询账户", notes = "按账户名查询账户")
    @GetMapping("/byName")
    fun findByName(name: String): Iterable<Account> = accountService.findByName(name)
}