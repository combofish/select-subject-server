package com.select.dao

import com.select.bean.Major

interface MajorDAO {
    fun saveMajor(major: Major?): Int
    fun queryMajorById(id: Int): Major?
}