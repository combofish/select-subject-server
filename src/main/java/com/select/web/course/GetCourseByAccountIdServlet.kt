package com.select.web.course

import com.google.gson.Gson
import com.select.bean.Course
import com.select.service.AccountService
import com.select.service.CourseService
import com.select.service.impl.AccountServiceImpl
import com.select.service.impl.CourseServiceImpl
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "GetCoursesByAccountIdServlet", value = ["/GetCoursesByAccountIdServlet"])
class GetCourseByAccountIdServlet : HttpServlet() {
    private val courseService: CourseService = CourseServiceImpl()
    private val gson = Gson()
    private val accountService:AccountService = AccountServiceImpl()

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val accountId = request.getParameter("account")
        val coursesByAccountId = courseService.getCoursesByAccountId(accountId.toInt())
        for (course in coursesByAccountId!!){
            val queryAccountById = accountService.queryAccountById(course!!.account_id)
            course!!.account_name = queryAccountById?.name.toString()
        }

        val json = gson.toJson(coursesByAccountId)
        println("get course by account id:${accountId} servlet: ${json}")
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        writer.write(json)
        writer.flush()
    }
}