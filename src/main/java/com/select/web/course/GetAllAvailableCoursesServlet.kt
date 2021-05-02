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
import java.io.OutputStream

@WebServlet(name = "GetAllAvailableCoursesServlet", value = ["/GetAllAvailableCoursesServlet"])
class GetAllAvailableCoursesServlet : HttpServlet() {
    private val courseService: CourseService = CourseServiceImpl()
    private val gson = Gson()
    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val allCourses = courseService.allAvailableCourses
        val json = gson.toJson(allCourses)
        println(json)

        // response.setHeader("Access-Control-Allow-Origin", "*");
        // response.setHeader("Cache-Control", "no-cache");
        /**
         * response.setCharacterEncoding("UTF-8");
         * response.setContentType("application/json");
         * PrintWriter writer = response.getWriter();
         * writer.write(json);
         * writer.flush();
         */
        response.contentType = "application/json; charset=utf-8"
        response.characterEncoding = "UTF-8"
        val out: OutputStream = response.outputStream
        out.write(json.toByteArray(charset("UTF-8")))
        out.flush()
    }
}