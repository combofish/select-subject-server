package com.select.bean

class Account {
    var id: Int? = null
    var passport: String? = null
    var name: String? = null
    var password: String? = null
    var status: Int? = null
    var email: String? = null
    var phone: String? = null
    var sex: Int? = null
    var department_id: Int? = null
    var major_id: Int? = null
    var description: String? = null
    var last_login_time: Long = 0
    var create_time: Long = 0
    var update_time: Long = 0

    constructor() {}
    constructor(
        id: Int?,
        passport: String?,
        name: String?,
        password: String?,
        status: Int?,
        email: String?,
        phone: String?,
        sex: Int?,
        department_id: Int?,
        major_id: Int?,
        description: String?,
        last_login_time: Long,
        create_time: Long,
        update_time: Long
    ) {
        this.id = id
        this.passport = passport
        this.name = name
        this.password = password
        this.status = status
        this.email = email
        this.phone = phone
        this.sex = sex
        this.department_id = department_id
        this.major_id = major_id
        this.description = description
        this.last_login_time = last_login_time
        this.create_time = create_time
        this.update_time = update_time
    }

    override fun toString(): String {
        return "account{" +
                "id=" + id +
                ", passport='" + passport + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", department_id=" + department_id +
                ", major_id=" + major_id +
                ", description='" + description + '\'' +
                ", last_login_time=" + last_login_time +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}'
    }
}