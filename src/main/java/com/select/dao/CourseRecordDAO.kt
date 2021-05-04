package com.select.dao

import com.select.bean.CourseRecord

interface CourseRecordDAO {
    fun saveCourseRecord(courseRecord: CourseRecord): Int
    fun queryCourseRecordByCourseId(courseId: Int): List<CourseRecord?>?
    fun queryCourseRecordByAccountId(accountId: Int): List<CourseRecord?>?
    fun deleteCourseRecordById(id: Int): Int
}