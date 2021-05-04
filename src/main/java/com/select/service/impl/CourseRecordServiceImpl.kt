package com.select.service.impl

import com.select.service.CourseRecordService
import com.select.dao.CourseRecordDAO
import com.select.dao.impl.CourseRecordDAOImpl
import com.select.bean.CourseRecord

class CourseRecordServiceImpl : CourseRecordService {
    private val courseRecordDAO: CourseRecordDAO = CourseRecordDAOImpl()
    override fun saveCourseRecord(courseRecord: CourseRecord): Int {
        return 1
    }

    override fun getCourseRecordByStudentId(studentId: Int): List<CourseRecord?>? {
        return courseRecordDAO.queryCourseRecordByAccountId(studentId)
    }

    override fun getCourseRecordByTeacherId(teacherId: Int): List<CourseRecord?>? {
        return courseRecordDAO.queryCourseRecordByAccountId(teacherId)
    }
}