package com.select.utils

import com.select.utils.JDBCUtils.connection
import com.select.utils.JDBCUtils
import org.junit.Test
import java.lang.Exception

class JDBCUtilsTest {
    @Test
    fun testGetConn() {
        try {
            val connection = connection
            println(connection)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}