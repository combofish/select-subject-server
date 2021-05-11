package com.select.utils

import com.select.bean.Account
import com.select.bean.Course
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.nio.file.Files
import java.nio.file.Paths

class CsvDataImport {

    fun importAccounts(CSV_File_Path: String): List<Account> {
        val reader = Files.newBufferedReader(Paths.get(CSV_File_Path))
        val csvParser = CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())

        var students = mutableListOf<Account>()
        for (csvRecord in csvParser) {
            println("Record No - " + csvRecord.recordNumber)

            val passport = csvRecord.get("passport")
            val name = csvRecord.get("name")
            val password = csvRecord.get("password")
            val status = csvRecord.get("status")
            val email = csvRecord.get("email")
            val phone = csvRecord.get("phone")
            val sex = csvRecord.get("sex")
            val department = csvRecord.get("department")
            val major = csvRecord.get("major")
            val description = csvRecord.get("description")

            var account = Account(
                passport = passport,
                name = name,
                password = password,
                status = status.toInt(),
                email = email,
                phone = phone,
                sex = sex.toInt(),
                department_id = IdNameTurn.departmentNameToId(department),
                major_id = IdNameTurn.majorNameToId(major),
                description = description,
            )
            students.add(account)
        }
        return students
    }

    fun importCourses(CSV_File_Path: String): List<Course> {
        var courses = mutableListOf<Course>()
        val reader = Files.newBufferedReader(Paths.get(CSV_File_Path))
        val csvParser = CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())

        for (csvRecord in csvParser) {
            println("Record No - " + csvRecord.recordNumber)
            val name = csvRecord.get("name")
            val credit = csvRecord.get("credit")
            val class_time = csvRecord.get("class_time")
            val teach_time = csvRecord.get("teach_time")
            val classroom = csvRecord.get("classroom")
            val account = csvRecord.get("account_id")
            val department = csvRecord.get("department")
            val major = csvRecord.get("major")
            val type = csvRecord.get("type")
            val require_type = csvRecord.get("require_type")
            val available_amount = csvRecord.get("available_amount")
            val introduction = csvRecord.get("introduction")

            val course = Course(
                name = name,
                credit = credit.toInt(),
                class_time = class_time.toInt(),
                teach_time = teach_time,
                classroom = classroom,
                account_id = IdNameTurn.passportToId(account), // 教师工号
                department_id = IdNameTurn.departmentNameToId(department),
                major_id = IdNameTurn.majorNameToId(major),
                type = type.toInt(),
                require_type = require_type.toInt(),
                available_amount = available_amount.toInt(),
                introduction = introduction
            )
            courses.add(course)
        }
        return courses
    }
}