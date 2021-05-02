package com.select.bean

class Course {
    var id: Int? = null
    var name: String? = null
    var credit: Int? = null
    var class_time: Int? = null
    var teach_time: String? = null
    var classroom: String? = null
    var account_id: Int? = null
    var department_id: Int? = null
    var major_id: Long = 0
    var type: Int? = null
    var require_type: Int? = null
    var available_amount: Int? = null
    var introduction: String? = null
    var create_time: Long = 0
    var update_time: Long = 0

    constructor() {}
    constructor(
        id: Int?,
        name: String?,
        credit: Int?,
        class_time: Int?,
        teach_time: String?,
        classroom: String?,
        account_id: Int?,
        department_id: Int?,
        major_id: Long,
        type: Int?,
        require_type: Int?,
        available_amount: Int?,
        introduction: String?,
        create_time: Long,
        update_time: Long
    ) {
        this.id = id
        this.name = name
        this.credit = credit
        this.class_time = class_time
        this.teach_time = teach_time
        this.classroom = classroom
        this.account_id = account_id
        this.department_id = department_id
        this.major_id = major_id
        this.type = type
        this.require_type = require_type
        this.available_amount = available_amount
        this.introduction = introduction
        this.create_time = create_time
        this.update_time = update_time
    }

    override fun toString(): String {
        return "Cource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", class_time=" + class_time +
                ", teach_time='" + teach_time + '\'' +
                ", classroom='" + classroom + '\'' +
                ", account_id=" + account_id +
                ", department_id=" + department_id +
                ", major_id=" + major_id +
                ", type=" + type +
                ", require_type=" + require_type +
                ", available_amount=" + available_amount +
                ", introduction='" + introduction + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}'
    }
}