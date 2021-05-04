package com.select.service.impl

import com.select.service.AccountService
import com.select.dao.AccountDAO
import com.select.dao.impl.AccountDAOImpl
import com.select.bean.Account

class AccountServiceImpl : AccountService {
    private val accountDAO: AccountDAO = AccountDAOImpl()
    override fun registerStudent(account: Account): Int {
        account!!.status = 0
        return accountDAO.saveAccount(account)
    }

    override fun registerTeacher(account: Account): Int {
        account!!.status = 1
        return accountDAO.saveAccount(account)
    }

    override fun AccountLogin(account: Account): Account? {
        return accountDAO.queryAccountByPassportAndPassword(account!!.passport, account.password)
    }

    override fun existAccountPassport(passport: String): Boolean {
        return accountDAO.queryAccountByPassport(passport) != null
    }
}