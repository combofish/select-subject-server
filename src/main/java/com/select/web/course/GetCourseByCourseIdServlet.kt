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

@WebServlet(name = "GetCourseByCourseIdServlet", value = ["/GetCourseByCourseIdServlet"])
class GetCourseByCourseIdServlet : HttpServlet() {
    private val courseService: CourseService = CourseServiceImpl()
    private val gson = Gson()

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val courseId = request.getParameter("course")
        val courseByCourseId = courseService.getCourseByCourseId(courseId.toInt())
        val json = gson.toJson(courseByCourseId)
        println("get course by course id servlet: ${json}")
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        writer.write(json)
        writer.flush()
    }
}