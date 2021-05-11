package com.select.service.impl

import junit.framework.TestCase
import com.select.service.AccountService
import com.select.bean.Account

class AccountServiceImplTest : TestCase() {
    var accountService: AccountService = AccountServiceImpl()
    fun testRegisterStudent() {
        val account = Account()
        account.name = "王刘海"
        account.passport = "172071"
        account.password = "123456"
        account.department_id = 1
        account.major_id = 1
        account.sex = 1
        account.phone = "18011119999"
        account.status = 0
        account.email = "wangliuhai@hebut.com"
        accountService.registerStudent(account)
    }

    fun testRegisterTeacher() {
        val account = Account()
        account.name = "孙大仙"
        account.passport = "172072"
        account.password = "123456"
        account.department_id = 1
        account.major_id = 1
        account.sex = 1
        account.phone = "18011117777"
        account.status = 1
        account.email = "sundaxian@hebut.com"
        accountService.registerStudent(account)
    }

    fun testAccountLogin() {
        val account = Account()
        account.password = "123456"
        account.passport = "172071"
        val account1 = accountService.accountLogin(account)
        println(account1 == null)
    }

    fun testExistAccountPassport() {
        val e = accountService.existAccountPassport("172071")
        println(e)
    }
}