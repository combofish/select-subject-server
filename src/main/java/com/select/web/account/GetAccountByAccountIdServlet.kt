package com.select.web.account

import com.google.gson.Gson
import com.select.service.impl.AccountServiceImpl
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "GetAccountByAccountIdServlet", value = ["/GetAccountByAccountIdServlet"])
class GetAccountByAccountIdServlet : HttpServlet() {
    private val accountService = AccountServiceImpl()
    private var gson = Gson()
    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val accountId = request.getParameter("account")
        val queryAccountById = accountService.queryAccountById(accountId.toInt())

        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        val toJson = gson.toJson(queryAccountById)
        writer.write(toJson)
        println("GetAccountByAccountIdServlet: ${toJson}")
        writer.flush()
    }

}