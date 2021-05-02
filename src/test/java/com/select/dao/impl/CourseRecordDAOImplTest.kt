package com.select.dao.impl

import junit.framework.TestCase
import com.select.dao.impl.CourseRecordDAOImpl
import com.select.bean.CourseRecord

class CourseRecordDAOImplTest : TestCase() {
    var courseRecordDAO = CourseRecordDAOImpl()
    fun testSaveCourseRecord() {
        val courseRecord = CourseRecord()
        courseRecord.course_id = 2
        courseRecord.account_id = 1
        val i = courseRecordDAO.saveCourseRecord(courseRecord)
        println(i)
        println(courseRecord)
    }

    fun testQueryCourseRecordByCourseId() {
        val courseRecords = courseRecordDAO.queryCourseRecordByCourseId(2)
        println(courseRecords)
    }

    fun testQueryCourseRecordByAccountId() {
        val courseRecords = courseRecordDAO.queryCourseRecordByAccountId(1)
        println(courseRecords)
    }

    fun testDeleteCourseRecordById() {
        val res = courseRecordDAO.deleteCourseRecordById(1)
        println(res)
    }
}