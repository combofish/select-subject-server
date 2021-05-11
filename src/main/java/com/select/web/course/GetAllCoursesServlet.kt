package com.select.web.course

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import com.select.service.CourseService
import com.select.service.impl.CourseServiceImpl
import com.google.gson.Gson
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.select.bean.Course
import com.select.service.AccountService
import com.select.service.impl.AccountServiceImpl
import java.io.PrintWriter

@WebServlet(name = "GetAllCoursesServlet", value = ["/GetAllCoursesServlet"])
class GetAllCoursesServlet : HttpServlet() {
    private val courseService: CourseService = CourseServiceImpl()
    private val accountService:AccountService = AccountServiceImpl()
    private val gson = Gson()
    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val allCourses = courseService.allCourses as MutableList<Course>
        for (course in allCourses){
            val queryAccountById = accountService.queryAccountById(course.account_id)
            course.account_name = queryAccountById?.name.toString()
        }
        val json = gson.toJson(allCourses)
        println(json)
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        writer.write(json)
        writer.flush()
    }
}