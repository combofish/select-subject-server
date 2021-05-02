package com.select.dao.impl

import com.select.dao.BaseDao
import com.select.dao.MajorDAO
import com.select.bean.Major

class MajorDAOImpl : BaseDao(), MajorDAO {
    override fun saveMajor(major: Major): Int {
        val sql = "insert into major(name,department_id) values(?,?)"
        return update(sql, major.name, major.department_id)
    }

    override fun queryMajorById(id: Int): Major {
        val sql = "select id,name,department_id from major where id = ?"
        return queryForOne(Major::class.java, sql, id)
    }
}