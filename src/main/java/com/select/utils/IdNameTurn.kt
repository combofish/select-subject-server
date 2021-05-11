package com.select.utils

import com.select.dao.AccountDAO
import com.select.dao.impl.AccountDAOImpl

object IdNameTurn {
    private val accountDAO: AccountDAO = AccountDAOImpl()

    fun majorIdToName(id:Int): String {
        return when (id) {
            1 -> "电子科学与技术"
            2 -> "电子信息工程"
            3 -> "通信工程"
            else -> ""
        }
    }

    fun majorNameToId(name:String):Int{
        return when(name){
            "电子科学与技术"-> 1
            "电子信息工程" -> 2
            "通信工程" -> 3
            else -> 0
        }
    }

    fun departmentIdToName(id: Int):String{
        if (id == 1) return "电子信息工程学院" else return ""
    }

    fun departmentNameToId(name: String):Int{
        if ("电子信息工程学院" == name)
            return 1
        else
            return 0
    }

    fun passportToId(passport:String):Int{
        val queryAccountByPassport = accountDAO.queryAccountByPassport(passport)
        return queryAccountByPassport?.id ?: 0
    }
}