package com.select.utils

import com.alibaba.druid.pool.DruidDataSourceFactory
import kotlin.Throws
import java.sql.SQLException
import com.select.utils.JDBCUtils
import org.apache.commons.dbutils.DbUtils
import java.lang.Exception
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.util.Properties
import javax.sql.DataSource

object JDBCUtils {
    private var source_use: DataSource? = null

    @JvmStatic
    @get:Throws(SQLException::class)
    val connection: Connection
        get() = source_use!!.connection

    @JvmStatic
    fun close(connection: Connection?) {
        DbUtils.closeQuietly(connection)
    }

    fun closeResource(conn: Connection?, ps: Statement?) {
        try {
            ps?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun closeResource(conn: Connection?, ps: Statement?, rs: ResultSet?) {
        DbUtils.closeQuietly(conn)
        DbUtils.closeQuietly(ps)
        DbUtils.closeQuietly(rs)
    }

    init {
        try {
            val pros = Properties()

            // InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            // pros.load(is);
            pros.setProperty("url", "jdbc:mysql:///selectSubject")
            pros.setProperty("username", "larry")
            pros.setProperty("password", "Confidence*1234")
            pros.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver")
            pros.setProperty("initialSize", "10")
            pros.setProperty("maxActive", "10")
            println(pros)
            source_use = DruidDataSourceFactory.createDataSource(pros)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}