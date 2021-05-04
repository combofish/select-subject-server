package com.select.dao.impl

import com.select.dao.BaseDao
import com.select.dao.CourseRecordDAO
import com.select.bean.CourseRecord

class CourseRecordDAOImpl : BaseDao(), CourseRecordDAO {
    override fun queryCourseRecordByCourseId(courseId: Int): List<CourseRecord?>? {
        val sql = "select id,course_id,account_id from course_record where course_id = ?"
        return queryForList(CourseRecord::class.java, sql, courseId)
    }

    override fun saveCourseRecord(course_record: CourseRecord): Int {
        val sql = "insert into course_record(course_id,account_id) values(?,?)"
        return update(sql, course_record.course_id, course_record.account_id)
    }

    override fun queryCourseRecordByAccountId(accountId: Int): List<CourseRecord?>? {
        val sql = "select id,course_id,account_id from course_record where account_id = ?"
        return queryForList(CourseRecord::class.java, sql, accountId)
    }

    override fun deleteCourseRecordById(id: Int): Int {
        val sql = "delete from course_record where id = ?"
        return update(sql, id)
    }

}