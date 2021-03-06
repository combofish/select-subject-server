drop database if exists selectSubject;
create database selectSubject;
use selectSubject;

create table `department` (
`id` int(20) not null auto_increment comment '主键',
`name` varchar(32) not null comment '院系名称',
`introduction` varchar(128) comment '简介',
`create_time` bigint(20) not null default '0' comment '创建时间',
`update_time` bigint(20) default null comment '更新时间',
primary key (`id`)
) comment='院系';

create table `major` (
`id` int(20) not null auto_increment comment '主键',
`name` varchar(32) not null comment '专业名称',
`introduction` varchar(128) comment '简介',
`department_id` int(20) not null comment '院系',
`create_time` bigint(20) not null default '0' comment '创建时间',
`update_time` bigint(20) default null comment '更新时间',
foreign key(department_id) references department(id),
primary key (`id`)
)  comment='专业';

create table `account` (
`id` int(20) not null auto_increment comment '主键',
`passport` varchar(20) not null comment '账号',
`name` varchar(20) not null comment '名称',
`password` varchar(64) not null comment '密码',
`status` int(11) not null default '0' comment '用户状态 0：学生; 1:老师',
`email` varchar(32) comment '邮箱',
`phone` varchar(16) comment '手机号',
`sex` int(11) not null default '0' comment '性别 0：女；1：男',
`department_id` int(20) not null comment '院系',
`major_id` int(20) not null comment '专业',
`description` varchar(128) default null comment '备注',
`last_login_time` bigint(20) default null comment '最近登录时间',
`create_time` bigint(20) not null default '0' comment '创建时间',
`update_time` bigint(20) default null comment '更新时间',
primary key (`id`),
foreign key(department_id) references department(id),
foreign key(major_id) references major(id),
unique(passport)
) comment='账号';

create table `course` (
`id` int(20) not null auto_increment comment '主键',
`name` varchar(64) not null comment '课程名称',
`credit` int(11) not null comment '学分',
`class_time` int(11) not null comment '课时',
`teach_time` varchar(32) not null comment '上课时间',
`classroom` varchar(32) not null comment '教室',
`account_id` int(20) not null comment '老师',
`department_id` int(20) not null comment '所属院系',
`major_id` int(20) not null comment '所属专业',
`type` int(11) not null default '1' comment '类型;1:选修课 2:必修课',
`require_type` int(11) not null default '1' comment '选课限制;1:同院系 2:同专业 3:无限制',
`available_amount` int(11) not null comment '剩余人数',
`introduction` varchar(128) comment '简介',
`create_time` bigint(20) not null default '0' comment '创建时间',
`update_time` bigint(20) default null comment '更新时间',
foreign key(department_id) references department(id),
foreign key(major_id) references major(id),
foreign key(account_id) references account(id),
primary key (`id`)
)  comment='课程';

create table `course_record` (
`id` int(20) not null auto_increment comment '主键',
`course_id` int(20) not null comment '课程',
`account_id` int(20) not null comment '学生',
`create_time` bigint(20) not null default '0' comment '选课时间',
`update_time` bigint(20) default null comment '更新时间',
foreign key(course_id) references course(id),
foreign key(account_id) references account(id),
primary key (`id`),
unique(course_id,account_id)
) comment='选课记录';


insert into department(name,introduction) values("电子信息工程学院","河北工业大学电子信息工程学院");
insert into department(name,introduction) values("人工智能学院","河北工业大学人工智能学院");

insert into major(name,introduction,department_id) values("电子科学与技术","河北工业大学电子科学与技术专业",1);
insert into major(name,introduction,department_id) values("电子信息工程","河北工业大学电子信息工程专业",1);
insert into major(name,introduction,department_id) values("通信工程","河北工业大学通信工程专业",1);
