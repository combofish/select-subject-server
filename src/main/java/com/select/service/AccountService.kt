package com.select.service

import com.select.bean.Account

interface AccountService {
    fun registerStudent(account: Account): Int
    fun registerTeacher(account: Account): Int
    fun AccountLogin(account: Account): Account?
    fun existAccountPassport(passport: String): Boolean
}