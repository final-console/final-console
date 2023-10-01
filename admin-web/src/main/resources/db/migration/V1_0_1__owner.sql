#DROP TABLE IF EXISTS owner;
CREATE TABLE IF NOT EXISTS `owner`
(
    id                 BIGINT              NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    user_id            BIGINT              NOT NULL COMMENT '用户ID',
    user_name          VARCHAR(200)        NOT NULL COMMENT '用户名称',
    avatar             VARCHAR(200)        NULL     DEFAULT NULL COMMENT '头像',
    name               VARCHAR(200) UNIQUE NOT NULL COMMENT '名称',
    type               VARCHAR(200)        NOT NULL COMMENT '类型',
    description        VARCHAR(200)        NULL     DEFAULT NULL COMMENT '描述',
    attributes         JSON                NULL COMMENT '扩展属性',
    version            INT                 NOT NULL DEFAULT 1 COMMENT '版本号',
    creator_id         BIGINT              NULL     DEFAULT NULL COMMENT '创建人ID',
    creator_name       VARCHAR(50)         NULL     DEFAULT NULL COMMENT '创建人名称',
    last_modifier_id   BIGINT              NULL     DEFAULT NULL COMMENT '创建人ID',
    last_modifier_name VARCHAR(50)         NULL     DEFAULT NULL COMMENT '创建人名称',
    created            DATETIME            NOT NULL DEFAULT NOW() COMMENT '创建时间',
    last_modified      DATETIME            NULL     DEFAULT NULL ON UPDATE NOW() COMMENT '最后修改时间',
    yn                 TINYINT             NOT NULL DEFAULT 1 COMMENT '有效标记，1：有效，0：无效'
);




