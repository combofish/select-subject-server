package com.select.service

import com.select.bean.Course

interface CourseService {
    fun saveCourse(course: Course): Int
    fun updateCourse(course: Course): Int
    fun isCourseAvailable(courseId:Int):Boolean
    fun afterSelectedUpdateCourseAvailableNumber(courseId: Int):Boolean
    fun afterCancelSelectedUpdateCourseAvailableNumber(courseId: Int):Boolean
    fun selectCoursesByStudentId(student_id: Int): List<Course?>?
    fun coursesPublicByTeacherId(teacher_id: Int): List<Course?>?
    val allAvailableCourses: List<Course?>?
    val allCourses: List<Course?>?
    fun getCourseByCourseId(id: Int): Course?
    fun getCourseByCourseName(courseName: String): List<Course?>? // 一个课可以有多个老师教授
    fun getCoursesByAccountId(accountId:Int):List<Course?>?
}