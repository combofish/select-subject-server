package com.select.dao.impl

import junit.framework.TestCase
import com.select.dao.impl.AccountDAOImpl
import com.select.bean.Account

class AccountDAOImplTest : TestCase() {
    var accountDAO = AccountDAOImpl()
    fun testQueryAccountByPassport() {
        val account = accountDAO.queryAccountByPassport("172070")
        println(account)
    }

    fun testQueryAccountByPassportAndPassword() {
        val account = accountDAO.queryAccountByPassportAndPassword("172068", "123456")
        println(account)
    }

    fun testSaveAccount() {
        val account = Account()
        account.name = "王六六"
        account.passport = "172068"
        account.password = "123456"
        account.department_id = 1
        account.major_id = 1
        account.sex = 1
        account.phone = "18011110000"
        account.status = 0
        account.email = "liuliu@hebut.com"
        val res = accountDAO.saveAccount(account)
        println(res)
        println(account)
    }

    fun testSaveAccount2() {
        val account = Account()
        account.name = "李大丁"
        account.passport = "172069"
        account.password = "123456"
        account.department_id = 1
        account.major_id = 1
        account.sex = 2
        account.phone = "18011123333"
        account.status = 0
        account.email = "lidading@hebut.com"
        val res = accountDAO.saveAccount(account)
        println(res)
        println(account)
    }

    fun testSaveAccount3_teacher() {
        val account = Account()
        account.name = "刘书磊"
        account.passport = "172070"
        account.password = "123456"
        account.department_id = 1
        account.major_id = 1
        account.sex = 2
        account.phone = "18011123333"
        account.status = 1
        account.email = "liushulei@hebut.com"
        val res = accountDAO.saveAccount(account)
        println(res)
        println(account)
    }
}