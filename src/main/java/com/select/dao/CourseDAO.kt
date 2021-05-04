package com.select.dao

import com.select.bean.Course

interface CourseDAO {
    fun saveCourse(course: Course): Int
    fun queryCourseByCourseId(courseId: Int): Course?
    fun queryCourseByCourseName(CourseName: String): List<Course?>?
    fun queryCourseByAccountId(accountId: Int): List<Course?>?
    fun queryAllCourses(): List<Course?>?
    fun queryAllAvailableCourses(): List<Course?>?
    fun deleteCourseById(id: Int): Int
}