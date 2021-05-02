package com.select.dao

import com.select.bean.Account

interface AccountDAO {
    fun queryAccountByPassport(passport: String?): Account?
    fun queryAccountByPassportAndPassword(passport: String?, password: String?): Account?
    fun saveAccount(account: Account?): Int
}