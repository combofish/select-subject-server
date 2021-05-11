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

@WebServlet(name = "CancelSelectCourseServlet", value = ["/CancelSelectCourseServlet"])
class CancelSelectCourseServlet : HttpServlet() {
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
        val courseRecordByAccountIdAndCourseId =
            courseRecordService.getCourseRecordByAccountIdAndCourseId(account_id.toInt(), course_id.toInt())

        if (courseRecordByAccountIdAndCourseId == null) {
            // 未找到记录
            selectSuccess = false
            resultMessage.setData(16, "No courseRecord found!")
        } else {
            // 有记录
            val deleteCourseRecordByCourseRecordId =
                courseRecordService.deleteCourseRecordByCourseRecordId(courseRecordByAccountIdAndCourseId.id)
            if (deleteCourseRecordByCourseRecordId.equals(1)) {
                // 删除成功

                // 需要更新课程记录
                val afterCancelSelectedUpdateCourseAvailableNumber =
                    courseService.afterCancelSelectedUpdateCourseAvailableNumber(course_id.toInt())
                selectSuccess = afterCancelSelectedUpdateCourseAvailableNumber
                resultMessage.setData(17, "delete courseRecord success")
            } else {
                // 删除失败
                resultMessage.setData(18, "delete courseRecord fail")
                selectSuccess = false
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