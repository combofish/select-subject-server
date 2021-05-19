package com.select.utils

import com.select.dao.impl.AccountDAOImpl
import com.select.dao.impl.CourseDAOImpl
import junit.framework.TestCase

/**
 * author:combofish
 * email:combofish49@gmail.com
 */
class CsvDataImportTest : TestCase(){

    private var csvDataImport = CsvDataImport()
    private var accountDAO = AccountDAOImpl()
    private var courseDao = CourseDAOImpl()

    /**
     * 从文件中导入学生数据
     */
    fun testImportStudent(){
        var path = "/home/larry/GitProjects/select-subject-server/data-student.csv"
        var students = csvDataImport.importAccounts(path)
        //println(students.toString())

        for (student in students){
            println(student.toString())
            println("save: ${accountDAO.saveAccount(student)}")
        }
    }

    /**
     * 从文件中导入老师数据
     */
    fun testImportTeacher(){
        var path = "/home/larry/GitProjects/select-subject-server/data-teacher.csv"
        var teachers = csvDataImport.importAccounts(path)
        println(teachers.toString())

        for(teacher in teachers){
            println(teacher.toString())
            println("save: ${accountDAO.saveAccount(teacher)}")
        }
    }

    /**
     * 从文件中导入课程数据
     */
    fun testImportCourse(){
        var path = "/home/larry/GitProjects/select-subject-server/data-course.csv"
        var courses = csvDataImport.importCourses(path)
        // println(courses.toString())
        for (course in courses){
            println(course.toString())
            println("save: ${courseDao.saveCourse(course)}")
        }
    }

    /**
     * 一次性导入所有数据
     */
    fun testImportData(){
        testImportStudent()
        testImportTeacher()
        testImportCourse()
    }
}
