DROP TABLE security_menu;
CREATE TABLE IF NOT EXISTS security_menu
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    code               VARCHAR(200) NOT NULL COMMENT '编号',
    path               VARCHAR(200) NOT NULL COMMENT '路径',
    name               VARCHAR(200) NOT NULL COMMENT '名称',
    icon               VARCHAR(200) NULL     DEFAULT NULL COMMENT '图标',
    menu_render        BOOLEAN      NOT NULL DEFAULT TRUE COMMENT '是否渲染为菜单',
    parent_id          BIGINT       NOT NULL DEFAULT -1 COMMENT '父ID',
    sort_value         INT          NOT NULL DEFAULT 10000 COMMENT '排序值',
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

INSERT INTO security_menu (code, path, name, icon, parent_id, sort_value)
VALUES ('welcome', '/welcome', '欢迎', 'home', -1, 10000),
       ('setting', '/setting', '设置', 'setting', -1, 10000);

SET @menu_setting = (SELECT id
                     FROM security_menu
                     WHERE code = 'setting');
INSERT INTO security_menu (code, path, name, icon, menu_render, parent_id)
VALUES ('setting.menu', '/setting/menu', '菜单设置', 'setting', false, @menu_setting);





