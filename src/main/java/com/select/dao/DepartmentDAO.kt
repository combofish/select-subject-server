package com.select.dao

import com.select.bean.Department

interface DepartmentDAO {
    fun saveDepartment(department: Department?): Int
    fun queryDepartmentById(id: Int): Department?
}