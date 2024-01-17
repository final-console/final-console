DROP TABLE IF EXISTS authority;
CREATE TABLE IF NOT EXISTS authority
(
    id                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    code               VARCHAR(200) NOT NULL COMMENT '编号',
    name               VARCHAR(200) NOT NULL COMMENT '名称',
    description        VARCHAR(200) NULL     DEFAULT NULL COMMENT '描述',
    version            INT          NOT NULL DEFAULT 1 COMMENT '版本号',
    creator_id         BIGINT       NULL     DEFAULT NULL COMMENT '创建人ID',
    creator_name       VARCHAR(50)  NULL     DEFAULT NULL COMMENT '创建人名称',
    last_modifier_id   BIGINT       NULL     DEFAULT NULL COMMENT '修改人ID',
    last_modifier_name VARCHAR(50)  NULL     DEFAULT NULL COMMENT '修改人名称',
    created            DATETIME     NOT NULL DEFAULT NOW() COMMENT '创建时间',
    last_modified      DATETIME     NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后修改时间',
    yn                 TINYINT      NOT NULL DEFAULT 1 COMMENT '有效标记，1：有效，0：无效'
);

INSERT INTO authority (code, name)
VALUES ('default:menu:list', '菜单-列表'),
       ('default:menu:detail', '菜单-详情'),
       ('default:menu:delete', '菜单-删除');




