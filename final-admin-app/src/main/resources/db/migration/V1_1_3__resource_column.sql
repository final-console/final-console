DROP TABLE IF EXISTS resource_column;
CREATE TABLE IF NOT EXISTS resource_column
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    resource           VARCHAR(200) NOT NULL COMMENT '编号',
    title              VARCHAR(200) NOT NULL COMMENT '标题',
    data_index         VARCHAR(200) NOT NULL COMMENT '数据索引',
    value_type         VARCHAR(200) NOT NULL DEFAULT 'text' COMMENT '数据类型',
    width              INT          NULL     DEFAULT NULL COMMENT '宽度',
    sorter             BOOLEAN      NULL     DEFAULT NULL COMMENT '是否可排序',
    default_sort_order VARCHAR(200) NULL     DEFAULT NULL COMMENT '默认排序',
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


INSERT INTO resource_column (resource, title, data_index, value_type, width, sorter, default_sort_order)
VALUES ('menus', '排序', 'sort', 'text', 60, null, null),
       ('menus', '#', 'sortValue', 'indexBorder', null, true, 'ascend'),
       ('menus', 'ID', 'id', 'number', null, null, null),
       ('menus', '路径', 'path', 'text', null, null, null),
       ('menus', '图标', 'icon', 'icon', 100, null, null),
       ('menus', '名称', 'name', 'text', null, null, null),
       ('menus', '创建时间', 'created', 'dateTime', null, null, null),
       ('menus', '最后修改时间', 'lastModified', 'dateTime', null, null, null),

       ('authorities', '排序', 'sort', 'text', 60, null, null),
       ('authorities', '#', 'index', 'indexBorder', null, true, null),
       ('authorities', '编码', 'code', 'text', null, null, null),
       ('authorities', '名称', 'name', 'text', null, null, null),
       ('authorities', '创建时间', 'created', 'dateTime', null, null, null),
       ('authorities', '最后修改时间', 'lastModified', 'dateTime', null, null, null),

       ('roles', 'ID', 'id', 'text', null, true, null),
       ('roles', '编码', 'code', 'text', null, null, null),
       ('roles', '名称', 'name', 'text', null, null, null),
       ('roles', '创建时间', 'created', 'dateTime', null, null, null),
       ('roles', '最后修改时间', 'lastModified', 'dateTime', null, null, null)
;






