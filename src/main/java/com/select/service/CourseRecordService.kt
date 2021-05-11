package com.select.service

import com.select.bean.CourseRecord

interface CourseRecordService {
    fun saveCourseRecord(courseRecord: CourseRecord): Int
    fun existCourseRecord(courseRecord: CourseRecord): Boolean
    // public List<CourseRecord> getAllRecord();
    fun getCourseRecordByStudentId(student_id: Int): List<CourseRecord?>?
    fun getCourseRecordByTeacherId(teacher_id: Int): List<CourseRecord?>?
    fun getCourseRecordByAccountId(accountId:Int):List<CourseRecord?>?
    fun getCourseRecordByAccountIdAndCourseId(accountId: Int,courseId:Int):CourseRecord?
    fun deleteCourseRecordByCourseRecordId(courseRecordId:Int):Int
}