package com.select.web.record

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import com.select.service.CourseRecordService
import com.select.service.impl.CourseRecordServiceImpl
import com.google.gson.Gson
import com.select.bean.Course
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.select.bean.CourseRecord
import com.select.service.AccountService
import com.select.service.CourseService
import com.select.service.impl.AccountServiceImpl
import com.select.service.impl.CourseServiceImpl

@WebServlet(name = "GetSelectedCoursesByAccountIdServlet", value = ["/GetSelectedCoursesByAccountIdServlet"])
class GetSelectedCoursesByAccountIdServlet : HttpServlet() {
    private val courseRecordService: CourseRecordService = CourseRecordServiceImpl()
    private val courseService: CourseService = CourseServiceImpl()
    private val accountService:AccountService = AccountServiceImpl()
    private val gson = Gson()
    private lateinit var json:String


    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val accountId = request.getParameter("account")
        val courseRecordByAccountId = courseRecordService.getCourseRecordByAccountId(accountId.toInt())

        if (courseRecordByAccountId!!.isEmpty()) {
            // 没有选课记录
            json = gson.toJson(courseRecordByAccountId)
        } else {
            // 有选课记录
            // 记录课程
                var courses = mutableListOf<Course>()
            for (courseRecord in courseRecordByAccountId) {
                val courseByCourseId = courseService.getCourseByCourseId(courseRecord!!.course_id)
                val queryAccountById = accountService.queryAccountById(courseByCourseId!!.account_id)
                courseByCourseId!!.account_name = queryAccountById?.name.toString()
                println(">>>> Selected Course: ${courseByCourseId}")
                courses.add(courseByCourseId!!)
            }
            println("Selected Courses: ${courses}")
            json = gson.toJson(courses)
        }
        println(courseRecordByAccountId)


        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        writer.write(json)
        writer.flush()
        /**
        val courseId = request.getParameter("course")
        val courseByCourseId = courseService.getCourseByCourseId(courseId.toInt())
        val json = gson.toJson(courseByCourseId)
        println("get course by course id servlet: ${json}")
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        writer.write(json)
        writer.flush()
         */
    }
}