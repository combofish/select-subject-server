package com.select.dao.impl

import junit.framework.TestCase
import com.select.dao.impl.CourseDAOImpl
import com.select.bean.Course

class CourseDAOImplTest : TestCase() {
    var courseDAO = CourseDAOImpl()
    fun testSaveCourse() {
        val course = Course()
        course.name = "嵌入式系统设计"
        course.credit = 2
        course.class_time = 48
        course.teach_time = "8:30-10:05"
        course.classroom = "B105"
        course.account_id = 2
        course.department_id = 1
        course.major_id = 1
        course.available_amount = 30
        val res = courseDAO.saveCourse(course)
        println(res)
        println(course)
    }

    fun testQueryCourseByName() {
        val courses = courseDAO.queryCourseByCourseName("嵌入式系统设计")
        println(courses)
    }

    fun testQueryCourseByAccountId() {
        val courses = courseDAO.queryCourseByAccountId(2)
        println(courses)
    }

    fun testDeleteCourseById() {
        val res = courseDAO.deleteCourseById(1)
        println(res)
    }

    // pass
    fun testQueryAllCourses() {
        val courses = courseDAO.queryAllCourses()
        println(courses)
    }

    // pass
    fun testQueryAllAvailableCourses() {
        val courses = courseDAO.queryAllAvailableCourses()
        println(courses)
    }
}