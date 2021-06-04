package com.select.service.impl

import com.select.service.CourseService
import com.select.dao.CourseDAO
import com.select.dao.impl.CourseDAOImpl
import com.select.bean.Course

class CourseServiceImpl : CourseService {
    private val courseDAO: CourseDAO = CourseDAOImpl()
    override fun saveCourse(course: Course): Int {
        return courseDAO.saveCourse(course)
    }

    override fun isCourseAvailable(courseId: Int): Boolean {
        return courseDAO.queryCourseByCourseId(courseId)!!.available_amount >= 1
    }

    override fun afterCancelSelectedUpdateCourseAvailableNumber(courseId: Int): Boolean {
        // if (!isCourseAvailable(courseId)) return false
        val course = courseDAO.queryCourseByCourseId(courseId)
        println("In afterCancelSelectedUpdateCourseAvailableNumber : ${course}")

        course!!.available_amount += 1
        return if (course != null) {
            //courseDAO.saveCourse(course) == 1
            courseDAO.updateCourseAvailableAmount(course) == 1
        } else {
            false
        }
    }

    override fun getCoursesByAccountId(accountId: Int): List<Course?>? {
        return courseDAO.queryCourseByAccountId(accountId)
    }

    override fun afterSelectedUpdateCourseAvailableNumber(courseId: Int): Boolean {
        if (!isCourseAvailable(courseId)) return false
        val course = courseDAO.queryCourseByCourseId(courseId)
        println("In afterSelectedUpdateCourseAvailableNumber : ${course}")

        course!!.available_amount -= 1
        return if (course != null) {
            //courseDAO.saveCourse(course) == 1
            courseDAO.updateCourseAvailableAmount(course) == 1
        } else {
            false
        }
    }

    override fun updateCourse(course: Course): Int {
        return 1
    }

    override fun selectCoursesByStudentId(student_id: Int): List<Course?>? {
        return null
    }

    override fun coursesPublicByTeacherId(teacher_id: Int): List<Course?>? {
        return null
    }

    override val allCourses: List<Course?>?
        get() = courseDAO.queryAllCourses()

    override val allAvailableCourses: List<Course?>?
        get() = courseDAO.queryAllAvailableCourses()

    override fun getCourseByCourseId(id: Int): Course? {
        return courseDAO.queryCourseByCourseId(id)
    }

    override fun getCourseByCourseName(courseName: String): List<Course?>? {
        return courseDAO.queryCourseByCourseName(courseName)
    }
}