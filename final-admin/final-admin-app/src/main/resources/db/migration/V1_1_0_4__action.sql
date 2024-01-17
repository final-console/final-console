DROP TABLE IF EXISTS `action`;
CREATE TABLE IF NOT EXISTS `action`
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    resource           VARCHAR(200) NOT NULL COMMENT '编号',
    code               VARCHAR(200) NOT NULL COMMENT '编码',
    name               VARCHAR(200) NOT NULL COMMENT '名称',
    type               VARCHAR(200) NOT NULL COMMENT '类型',
    tips               VARCHAR(200) NULL     DEFAULT NULL COMMENT '提示',
    eval               VARCHAR(200) NULL     DEFAULT NULL COMMENT '表达式',
    position           VARCHAR(200) NOT NULL DEFAULT 'tableRow' COMMENT '位置',
    sort_value         INT          NOT NULL DEFAULT 10000 COMMENT '排序值',
    attributes         JSON         NULL     DEFAULT NULL COMMENT '扩展属性',
    version            INT          NOT NULL DEFAULT 1 COMMENT '版本号',
    creator_id         BIGINT       NULL     DEFAULT NULL COMMENT '创建人ID',
    creator_name       VARCHAR(50)  NULL     DEFAULT NULL COMMENT '创建人名称',
    last_modifier_id   BIGINT       NULL     DEFAULT NULL COMMENT '修改人ID',
    last_modifier_name VARCHAR(50)  NULL     DEFAULT NULL COMMENT '修改人名称',
    created            DATETIME     NOT NULL DEFAULT NOW() COMMENT '创建时间',
    last_modified      DATETIME     NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后修改时间',
    yn                 TINYINT      NOT NULL DEFAULT 1 COMMENT '有效标记，1：有效，0：无效'
);

INSERT INTO action (resource, code, name, type, tips)
VALUES ('columns', 'view', '查看', 'button', '查看'),
       ('columns', 'edit', '编辑', 'button', '编辑'),
       ('columns', 'delete', '删除', 'button', '删除');

INSERT INTO action (resource, code, name, type, tips)
VALUES ('actions', 'view', '查看', 'button', '查看'),
       ('actions', 'edit', '编辑', 'button', '编辑'),
       ('actions', 'delete', '删除', 'button', '删除');


INSERT INTO action (resource, code, name, type, tips,eval)
VALUES ('domain-entities', 'view', '查看', 'button', null,null),
       ('domain-entities', 'edit', '编辑', 'button', null,null),
       ('domain-entities', 'delete', '删除', 'button', null,null),
       ('domain-entities', 'enable', '启用', 'button', null,'entity.yn == 0'),
       ('domain-entities', 'disable', '禁用', 'button', null,'entity.yn == 1');
       ;



