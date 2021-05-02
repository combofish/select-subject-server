package com.select.web.record

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import com.select.service.CourseRecordService
import com.select.service.impl.CourseRecordServiceImpl
import com.google.gson.Gson
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.select.bean.CourseRecord

@WebServlet(name = "getSelectedCoursesByAccountIdServlet", value = ["/getSelectedCoursesByAccountIdServlet"])
class getSelectedCoursesByAccountIdServlet : HttpServlet() {
    private val courseRecordService: CourseRecordService = CourseRecordServiceImpl()
    private val gson = Gson()
    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val accountId = request.getParameter("accountId")
        val courseRecordByStudentId = courseRecordService.getCourseRecordByStudentId(accountId.toInt())
        println(courseRecordByStudentId)
    }
}