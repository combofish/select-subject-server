package com.select.web

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import com.select.service.AccountService
import com.select.service.impl.AccountServiceImpl
import com.google.gson.Gson
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.PrintWriter
import com.select.bean.Account

@WebServlet(name = "LoginServlet", value = ["/LoginServlet"])
class LoginServlet : HttpServlet() {
    private val accountService: AccountService = AccountServiceImpl()
    private val gson = Gson()
    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val passport = request.getParameter("passport")
        val password = request.getParameter("password")
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        val account = Account()
        account.passport = passport
        account.password = password
        val account_login = accountService.AccountLogin(account)
        val json = gson.toJson(account_login)
        if (account_login != null) {
            println("Login Success")
            writer.write(json)
        } else {
            println("Login Fail")
            writer.write("-1")
        }
        writer.flush()
    }
}