package com.select.bean

class Department {
    var id: Int? = null
    var name: String? = null
    var introduction: String? = null
    var create_time: Long = 0
    var update_time: Long = 0

    constructor() {}
    constructor(id: Int?, name: String?, introduction: String?, create_time: Long, update_time: Long) {
        this.id = id
        this.name = name
        this.introduction = introduction
        this.create_time = create_time
        this.update_time = update_time
    }

    override fun toString(): String {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}'
    }
}