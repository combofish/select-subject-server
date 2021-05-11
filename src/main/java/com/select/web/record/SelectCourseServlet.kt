package com.select.web.record

import com.combofish.selectsubject.bean.ResultMessage
import com.google.gson.Gson
import com.select.bean.CourseRecord
import com.select.service.impl.CourseRecordServiceImpl
import com.select.service.impl.CourseServiceImpl
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import kotlin.Throws
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "SelectCourseServlet", value = ["/SelectCourseServlet"])
class SelectCourseServlet : HttpServlet() {
    private val courseRecordService = CourseRecordServiceImpl()
    private val courseService = CourseServiceImpl()
    private val gson = Gson()
    private val resultMessage = ResultMessage()

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        var account_id = request.getParameter("account")
        var course_id = request.getParameter("course")
        var selectSuccess = false

        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        val writer = response.writer
        val courseRecord = CourseRecord(
            account_id = account_id.toInt(),
            course_id = course_id.toInt()
        )
        // 查看是否已经选课
        val existCourseRecord = courseRecordService.existCourseRecord(courseRecord)
        if (existCourseRecord) {
            selectSuccess = false
            println("Already exist such course record!")
            resultMessage.msg = "Existed course record"
            resultMessage.flag = 0
        } else {
            // 查看是否有余量
            val courseAvailable = courseService.isCourseAvailable(courseRecord.course_id)
            if (!courseAvailable) {
                println("Course available amount is null.")
                resultMessage.flag = 1
                resultMessage.msg = "Course available amount is null."
            } else {

                // 有余量，进行选课
                val saveCourseRecord = courseRecordService.saveCourseRecord(courseRecord)
                val json = gson.toJson(courseRecord)
                println("Select course: ${json},result: ${saveCourseRecord}")

                if (saveCourseRecord.equals(1)) {
                    // 选课成功，更新课程余量
                    val afterSelectedUpdateCourseAvailableNumber =
                        courseService.afterSelectedUpdateCourseAvailableNumber(courseRecord.course_id)
                    selectSuccess = afterSelectedUpdateCourseAvailableNumber
                    resultMessage.flag = 2
                    resultMessage.msg = "Select Course success."
                } else {
                    resultMessage.flag = 3
                    resultMessage.msg = "Select Course failed."
                }
            }
        }

        if (selectSuccess) {
            println("Select course success")
            //writer.write("{ \"result\",\"1\"}")
        } else {
            println("Select course failed")
            //writer.write("{ \"result\",\"-1\"}")
        }
        val toJson = gson.toJson(resultMessage)
        println("ResultMessage: ${toJson}")
        writer.write(toJson)
        writer.flush()
    }
}