package com.select.service

import com.select.bean.Account

interface AccountService {
    fun registerStudent(account: Account): Int
    fun registerTeacher(account: Account): Int
    fun accountLogin(account: Account): Account?
    fun existAccountPassport(passport: String): Boolean
    fun queryAccountById(id:Int):Account?
    fun changePasswordByAccountId(password: String,accountId:Int):Int
}