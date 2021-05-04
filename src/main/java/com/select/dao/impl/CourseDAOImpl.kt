package com.select.dao.impl

import com.select.dao.BaseDao
import com.select.dao.CourseDAO
import com.select.bean.Course

class CourseDAOImpl : BaseDao(), CourseDAO {

    override fun saveCourse(course: Course): Int {
        val sql =
            "insert into course(name,credit,class_time,teach_time,classroom,account_id,department_id,major_id,type,require_type,available_amount) values(?,?,?,?,?,?,?,?,?,?,?)"
        return update(
            sql, course.name, course.credit, course.class_time, course.teach_time,
            course.classroom, course.account_id, course.department_id, course.major_id,
            course.type, course.require_type, course.available_amount
        )
    }

    override fun queryCourseByCourseName(courseName: String): List<Course?>? {
        val sql =
            "select id,name,credit,class_time,teach_time,classroom,account_id,department_id,major_id,type,require_type,available_amount from course where name = ?"
        return queryForList(Course::class.java, sql, courseName)
    }

    override fun queryCourseByAccountId(accountId: Int): List<Course?>? {
        val sql =
            "select id,name,credit,class_time,teach_time,classroom,account_id,department_id,major_id,type,require_type,available_amount from course where account_id = ?"
        return queryForList(Course::class.java, sql, accountId)
    }

    override fun deleteCourseById(id: Int): Int {
        val sql = "delete from course where id = ?"
        return update(sql, id)
    }

    override fun queryCourseByCourseId(courseId: Int): Course? {
        val sql =
            "select id,name,credit,class_time,teach_time,classroom,account_id,department_id,major_id,type,require_type,available_amount from course where id = ?"
        return queryForOne(Course::class.java, sql, courseId)
    }

    override fun queryAllCourses(): List<Course?>? {
        val sql =
            "select id,name,credit,class_time,teach_time,classroom,account_id,department_id,major_id,type,require_type,available_amount from course"
        return queryForList(Course::class.java, sql)
    }

    override fun queryAllAvailableCourses(): List<Course?>? {
        val sql =
            "select id,name,credit,class_time,teach_time,classroom,account_id,department_id,major_id,type,require_type,available_amount from course where available_amount > 0"
        return queryForList(Course::class.java, sql)
    }

}