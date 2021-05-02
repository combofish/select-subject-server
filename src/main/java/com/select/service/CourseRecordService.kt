package com.select.service

import com.select.bean.CourseRecord

interface CourseRecordService {
    fun saveCourseRecord(courseRecord: CourseRecord?): Int?

    // public List<CourseRecord> getAllRecord();
    fun getCourseRecordByStudentId(student_id: Int?): List<CourseRecord?>?
    fun getCourseRecordByTeacherId(teacher_id: Int?): List<CourseRecord?>?
}