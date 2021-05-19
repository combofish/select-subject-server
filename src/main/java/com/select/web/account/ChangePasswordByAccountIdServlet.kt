package com.select.web.account

import com.combofish.selectsubject.bean.ResultMessage
import com.google.gson.Gson
import com.select.bean.Account
import com.select.service.impl.AccountServiceImpl
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "ChangePasswordByAccountIdServlet", value = ["/ChangePasswordByAccountIdServlet"])
class ChangePasswordByAccountIdServlet : HttpServlet() {

    private val accountService = AccountServiceImpl()
    private var gson = Gson()

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val accountId = request.getParameter("account")
        val password = request.getParameter("password")
        val oldPassword = request.getParameter("token")

        // API 更新
        val queryAccountById = accountService.queryAccountById(accountId.toInt())
        var res = 0
        if (queryAccountById!!.password.equals(oldPassword)) {
            println("用户id,密码验证通过")
            res =
                accountService.changePasswordByAccountId(password, accountId.toInt())
        } else {
            res = 0
        }

        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        var resultMessage = ResultMessage()

        resultMessage.flag = res
        resultMessage.msg = "change password"
        val toJson = gson.toJson(resultMessage)
        writer.write(toJson)
        println("Change password res: ${toJson}")
        writer.flush()
    }
}