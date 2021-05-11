package com.select.service.impl

import com.select.service.CourseRecordService
import com.select.dao.CourseRecordDAO
import com.select.dao.impl.CourseRecordDAOImpl
import com.select.bean.CourseRecord

class CourseRecordServiceImpl : CourseRecordService {
    private val courseRecordDAO: CourseRecordDAO = CourseRecordDAOImpl()

    override fun getCourseRecordByAccountIdAndCourseId(accountId: Int, courseId: Int): CourseRecord? {
        return courseRecordDAO.queryCourseRecordByCourseIdAndAccountId(courseId,accountId)
    }

    override fun deleteCourseRecordByCourseRecordId(courseRecordId: Int): Int {
       return courseRecordDAO.deleteCourseRecordById(courseRecordId)
    }

    override fun existCourseRecord(courseRecord: CourseRecord): Boolean {
        return courseRecordDAO.queryCourseRecordByCourseIdAndAccountId(courseRecord.course_id,courseRecord.account_id) != null
    }

    override fun saveCourseRecord(courseRecord: CourseRecord): Int {
        return courseRecordDAO.saveCourseRecord(courseRecord)
    }

    override fun getCourseRecordByStudentId(studentId: Int): List<CourseRecord?>? {
        return courseRecordDAO.queryCourseRecordByAccountId(studentId)
    }

    override fun getCourseRecordByTeacherId(teacherId: Int): List<CourseRecord?>? {
        return courseRecordDAO.queryCourseRecordByAccountId(teacherId)
    }

    override fun getCourseRecordByAccountId(accountId: Int): List<CourseRecord?>? {
        return courseRecordDAO.queryCourseRecordByAccountId(accountId)
    }

}