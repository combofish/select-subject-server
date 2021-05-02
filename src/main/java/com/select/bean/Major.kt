package com.select.bean

class Major {
    private var id: Int? = null
    var name: String? = null
    var introduction: String? = null
    var department_id: Long = 0
    var create_time: Long = 0
    var update_time: Long = 0

    constructor() {}
    constructor(
        id: Int?,
        name: String?,
        introduction: String?,
        department_id: Long,
        create_time: Long,
        update_time: Long
    ) {
        this.id = id
        this.name = name
        this.introduction = introduction
        this.department_id = department_id
        this.create_time = create_time
        this.update_time = update_time
    }

    override fun toString(): String {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", department_id=" + department_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}'
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }
}