CREATE TABLE `tb_area` (
  `area_id`        INT(2)      NOT NULL            AUTO_INCREMENT
  COMMENT '区域ID',
  `area_name`      VARCHAR(60) NOT NULL
  COMMENT '区域名称',
  `priority`       INT(2)      NOT NULL
  COMMENT '优先级',
  `create_time`    TIMESTAMP   NOT NULL            DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `last_edit_time` TIMESTAMP   NOT NULL            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最近修改时间',
  PRIMARY KEY (`area_id`)
    COMMENT 'area_id作为主键',
  UNIQUE KEY `UK_AREA`(`area_name`)
    COMMENT '区域名称唯一'
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = `utf8`