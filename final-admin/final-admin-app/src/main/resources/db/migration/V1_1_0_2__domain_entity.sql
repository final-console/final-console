DROP TABLE IF EXISTS domain_entity;
CREATE TABLE IF NOT EXISTS domain_entity
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    resource           VARCHAR(200) NOT NULL COMMENT '资源码',
    name               VARCHAR(200) NOT NULL COMMENT '名称',
    description        VARCHAR(200) NULL     DEFAULT NULL COMMENT '描述',
    attributes         JSON         NULL COMMENT '扩展属性',
    version            INT          NOT NULL DEFAULT 1 COMMENT '版本号',
    creator_id         BIGINT       NULL     DEFAULT NULL COMMENT '创建人ID',
    creator_name       VARCHAR(50)  NULL     DEFAULT NULL COMMENT '创建人名称',
    last_modifier_id   BIGINT       NULL     DEFAULT NULL COMMENT '修改人ID',
    last_modifier_name VARCHAR(50)  NULL     DEFAULT NULL COMMENT '修改人名称',
    created            DATETIME     NOT NULL DEFAULT NOW() COMMENT '创建时间',
    last_modified      DATETIME     NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后修改时间',
    yn                 TINYINT      NOT NULL DEFAULT 1 COMMENT '有效标记，1：有效，0：无效'
);

INSERT INTO domain_entity (resource, name, description)
VALUES ('domain-entities', '领域实体', '系统领域模型'),
       ('value-types', '值类型', '表单列值类型，如文本、密码等'),
       ('columns', '数据列', '领域实体数据列')
;





