package com.select.dao.impl

import com.select.dao.BaseDao
import com.select.dao.DepartmentDAO
import com.select.bean.Department

class DepartmentDAOImpl : BaseDao(), DepartmentDAO {
    override fun saveDepartment(department: Department): Int {
        val sql = "insert into department(name) values(?)"
        return update(sql, department.name)
    }

    override fun queryDepartmentById(id: Int): Department? {
        val sql = "select id,name from department where id = ?"
        return queryForOne(Department::class.java, sql, id)
    }
}