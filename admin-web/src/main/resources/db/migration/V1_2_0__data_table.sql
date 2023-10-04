DROP TABLE IF EXISTS resource_column;
CREATE TABLE IF NOT EXISTS resource_column
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    resource           VARCHAR(200) NOT NULL COMMENT '编号',
    title              VARCHAR(200) NOT NULL COMMENT '标题',
    data_index         VARCHAR(200) NOT NULL COMMENT '数据索引',
    value_type         VARCHAR(200) NOT NULL DEFAULT 'text' COMMENT '数据类型',
    width              INT          NULL     DEFAULT NULL COMMENT '宽度',
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


INSERT INTO resource_column (resource, title, data_index, value_type, width)
VALUES ('security-menus', '排序', 'sort', 'text', 60),
       ('security-menus', '#', 'index', 'indexBorder', 60),
       ('security-menus', '路径', 'path', 'text', null),
       ('security-menus', '名称', 'name', 'text', null),
       ('security-menus', '图标', 'icon', 'icon', 100);






