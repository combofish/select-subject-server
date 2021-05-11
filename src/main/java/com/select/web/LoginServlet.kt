package com.select.web

import com.combofish.selectsubject.bean.ResultMessage
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
        val account_login = accountService.accountLogin(account)
        var resultMessage = ResultMessage()

        //val json = gson.toJson(account_login)
        if (account_login != null) {
            println("Login Success")
            resultMessage.flag = 1
            resultMessage.msg = account_login?.id.toString()
        } else {
            println("Login Fail")
            resultMessage.flag = 0
            resultMessage.msg = "Login fail"
        }

        writer.write(gson.toJson(resultMessage))
        println("ResultMessage: ${resultMessage.toString()}")
        writer.flush()
    }
}