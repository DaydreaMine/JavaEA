create database `bysr`;
use `bysr`;

CREATE TABLE `user`
(
    `id`         INT(10) NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(64) UNIQUE DEFAULT '' COMMENT '用户名',
    `password`   VARCHAR(64)        DEFAULT '' COMMENT '密码',
    `email`      VARCHAR(64)        DEFAULT '' COMMENT '邮箱',
    `phone`      VARCHAR(64)        DEFAULT '' COMMENT '手机',
    `created_at` TIMESTAMP          DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP          DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `role`       VARCHAR(64)        DEFAULT '' COMMENT '权限',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='用户表';

CREATE TABLE `seat`
(
    `id`         INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(64) UNIQUE DEFAULT '' COMMENT '座位名',
    `status`     INT                DEFAULT 0 COMMENT '启用状态：0->禁用；1->启用',
    `created_at` TIMESTAMP          DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP          DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='座位表';

CREATE TABLE `seat_record`
(
    `id`         INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id`    INT(10) UNIQUE            DEFAULT 0 COMMENT '使用者id',
    `seat_name`  varchar(64) UNIQUE        DEFAULT '' COMMENT '座位名称',
    `data`       varchar(64)      NOT NULL DEFAULT 0 COMMENT '当前时间',
    `hour`       INT              NOT NULL DEFAULT 0 COMMENT '预约时间',
    `hasBooked`  TINYINT(1)                DEFAULT 0 COMMENT '预约状态：0->已预约；1->取消预约',
    `created_at` TIMESTAMP                 DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP                 DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='座位预约选择表';


