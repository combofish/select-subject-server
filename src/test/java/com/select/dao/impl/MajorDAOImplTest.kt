package com.select.dao.impl

import junit.framework.TestCase
import com.select.dao.impl.MajorDAOImpl
import com.select.bean.Major

class MajorDAOImplTest : TestCase() {
    var majorDAO = MajorDAOImpl()
    fun testSaveMajor() {
        val major = Major()
        // major.setName("电子科学与技术");
        // major.setName("电子信息工程");
        major.name = "通信工程"
        major.department_id = 1
        val result = majorDAO.saveMajor(major)
        println(result)
    }

    fun testSaveMajor1() {
        val major = Major()
        major.name = "电子科学与技术"
        // major.setName("电子信息工程");
        // major.setName("通信工程");
        major.department_id = 1
        val result = majorDAO.saveMajor(major)
        println(result)
    }

    fun testSaveMajor2() {
        val major = Major()
        // major.setName("电子科学与技术");
        major.name = "电子信息工程"
        major.department_id = 1
        // major.setName("通信工程");
        val result = majorDAO.saveMajor(major)
        println(result)
    }

    fun testQueryMajorById() {
        val major = majorDAO.queryMajorById(3)
        println(major)
    }
}