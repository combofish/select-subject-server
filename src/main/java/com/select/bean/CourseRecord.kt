package com.select.bean

class CourseRecord {
    var id: Int? = null
    var course_id: Int? = null
    var account_id: Int? = null
    var create_time: Long = 0
    var update_time: Long = 0

    constructor() {}
    constructor(id: Int?, course_id: Int?, account_id: Int?, create_time: Long, update_time: Long) {
        this.id = id
        this.course_id = course_id
        this.account_id = account_id
        this.create_time = create_time
        this.update_time = update_time
    }

    override fun toString(): String {
        return "Course_record{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", account_id=" + account_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}'
    }
}