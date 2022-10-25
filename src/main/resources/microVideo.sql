/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/24/2022 10:00:36 AM                       */
/*==============================================================*/


drop table if exists t_user;

drop table if exists t_admin;

drop table if exists t_video;

/*==============================================================*/
/* Table: t_user                                               */
/*==============================================================*/
create table t_user
(
    id          int not null auto_increment,
    nick_name   varchar(32),
    account     varchar(32),
    password    varchar(32),
    gender      boolean,
    birthday    date,
    phone       varchar(16),
    email       varchar(64),
    description text,
    primary key (id)
);

ALTER TABLE t_user
    COMMENT '用户表';
INSERT INTO t_user
VALUES (1, '张三', 'zhangsan', '123', true, '2002-10-10', '13966668888', 'zhangsan@gmail.com', '张三');

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
    id       int not null auto_increment,
    name     varchar(32),
    account  varchar(32),
    password varchar(32),
    primary key (id)
);

ALTER TABLE t_admin
    COMMENT '管理员表';
INSERT INTO t_admin
VALUES (1, '管理员', 'admin', '123');

drop table if exists t_video;

/*==============================================================*/
/* Table: t_video                                               */
/*==============================================================*/
create table t_video
(
    id          int not null auto_increment,
    name        varchar(256),
    author      varchar(64),
    type        varchar(32),
    create_time datetime,
    time_length int, /*--单位: 分钟*/
    video_path  varchar(256),
    cover_path  varchar(256),
    description text,
    primary key (id)
);

alter table t_video
    comment '视频表';
# insert into t_video
# values (1, 'He Let the Intrusive Thoughts Win', 'Daily doze of internet', 'life', '2022-10-10 10:10:10', 3,
#         '/Daily Dose Of Internet - 2022-10-24 - He Let the Intrusive Thoughts Win.mp4',
#         '/Daily Dose Of Internet - 2022-10-24 - He Let the Intrusive Thoughts Win.png', 'Made by love')

