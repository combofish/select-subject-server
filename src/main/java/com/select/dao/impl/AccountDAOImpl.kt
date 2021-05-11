package com.select.dao.impl

import com.select.dao.BaseDao
import com.select.dao.AccountDAO
import com.select.bean.Account

class AccountDAOImpl : BaseDao(), AccountDAO {

    override fun queryAccountByPassport(passport: String): Account? {
        val sql = "select `id`,`passport`,`password` from account where passport = ?"
        return queryForOne(Account::class.java, sql, passport)
    }

    override fun queryAccountByPassportAndPassword(passport: String?, password: String?): Account? {
        val sql =
            "select id,passport,name,password,department_id,major_id from account where passport = ? and password = ?"
        return queryForOne(Account::class.java, sql, passport, password)
    }

    override fun queryAccountById(id: Int): Account? {
        val sql =
            "select id,passport,name,password,department_id,major_id,status,email,phone,sex,description from account where id = ?"
        return queryForOne(Account::class.java, sql, id)
    }

    override fun saveAccount(account: Account): Int {
        val sql =
            "insert into account(passport,name,password,status,email,phone,sex,department_id,major_id,description) values(?,?,?,?,?,?,?,?,?,?)"
        return update(
            sql, account.passport, account.name, account.password, account.status, account.email,
            account.phone, account.sex, account.department_id, account.major_id, account.description
        )
    }

    override fun changePasswordByAccountId(password: String, id: Int): Int {
        val sql = "update account set password=? where id=?"
        return update(sql, password, id)
    }
}