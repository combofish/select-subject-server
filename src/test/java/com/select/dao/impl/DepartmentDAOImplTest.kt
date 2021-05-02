package com.select.dao.impl

import junit.framework.TestCase
import com.select.dao.impl.DepartmentDAOImpl
import com.select.bean.Department

class DepartmentDAOImplTest : TestCase() {
    var departmentDAO = DepartmentDAOImpl()
    fun testSaveDepartment() {
        val department = Department()
        department.name = "电子信息工程学院"
        val res = departmentDAO.saveDepartment(department)
        println(res)
    }

    fun testQueryDepartmentById() {
        val department = departmentDAO.queryDepartmentById(1)
        println(department)
    }
}