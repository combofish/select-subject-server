package com.select.dao

import com.select.utils.JDBCUtils.connection
import com.select.utils.JDBCUtils.close
import org.apache.commons.dbutils.QueryRunner
import com.select.utils.JDBCUtils
import java.sql.SQLException
import org.apache.commons.dbutils.handlers.BeanHandler
import org.apache.commons.dbutils.handlers.BeanListHandler
import org.apache.commons.dbutils.handlers.ScalarHandler
import java.sql.Connection

abstract class BaseDao {
    private val queryRunner = QueryRunner()
    fun update(sql: String?, vararg args: Any?): Int {
        var connection: Connection? = null
        try {
            connection = JDBCUtils.connection
            return queryRunner.update(connection, sql, *args)
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            close(connection)
        }
        return -1
    }

    fun <T> queryForOne(type: Class<T>?, sql: String?, vararg args: Any?): T? {
        var connection: Connection? = null
        try {
            connection = JDBCUtils.connection
            return queryRunner.query(connection, sql, BeanHandler(type), *args)
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            close(connection)
        }
        return null
    }

    fun <T> queryForList(type: Class<T>?, sql: String?, vararg args: Any?): List<T>? {
        var connection: Connection? = null
        try {
            connection = JDBCUtils.connection
            return queryRunner.query(connection, sql, BeanListHandler(type), *args)
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            close(connection)
        }
        return null
    }

    fun queryForSingleValue(sql: String?, vararg args: Any?): Any? {
        var connection: Connection? = null
        try {
            connection = JDBCUtils.connection
            return queryRunner.query(connection, sql, ScalarHandler(), *args)
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            close(connection)
        }
        return null
    }
}