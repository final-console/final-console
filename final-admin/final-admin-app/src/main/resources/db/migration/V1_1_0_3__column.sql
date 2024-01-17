DROP TABLE IF EXISTS `column`;
CREATE TABLE IF NOT EXISTS `column`
(
    id                   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',
    resource             VARCHAR(200) NOT NULL COMMENT '编号',
    view                 VARCHAR(200) NOT NULL DEFAULT 'list' COMMENT '视图',
    title                VARCHAR(200) NOT NULL COMMENT '标题',
    data_index           VARCHAR(200) NOT NULL COMMENT '数据索引',
    value_type           VARCHAR(200) NOT NULL DEFAULT 'text' COMMENT '数据类型',
    tip_title            VARCHAR(200) NULL     DEFAULT NULL COMMENT '提示标题',
    tip_icon             VARCHAR(200) NULL     DEFAULT NULL COMMENT '提示图标',
    width                INT          NULL     DEFAULT NULL COMMENT '宽度',
    sorter               BOOLEAN      NULL     DEFAULT NULL COMMENT '是否可排序',
    default_sort_order   VARCHAR(200) NULL     DEFAULT NULL COMMENT '默认排序',
    readonly             BOOLEAN      NOT NULL DEFAULT false COMMENT '只读，修改时不可编辑',
    filter               BOOLEAN      NOT NULL DEFAULT false COMMENT '是否可过滤',
    hide_in_form         BOOLEAN      NOT NULL DEFAULT false COMMENT '在 Form 中隐藏',
    hide_in_table        BOOLEAN      NOT NULL DEFAULT false COMMENT '在 Table 中隐藏',
    hide_in_search       BOOLEAN      NOT NULL DEFAULT false COMMENT '在 Table 的查询表单中隐藏',
    hide_in_descriptions BOOLEAN      NOT NULL DEFAULT false COMMENT '在 descriptions 中隐藏',
    sort_value           INT          NOT NULL DEFAULT 10000 COMMENT '排序值',
    value_enum           JSON         NULL     DEFAULT NULL COMMENT '枚举值',
    parent_id            BIGINT       NOT NULL DEFAULT -1 COMMENT '父级ID',
    attributes           JSON         NULL     DEFAULT NULL COMMENT '扩展属性',
    version              INT          NOT NULL DEFAULT 1 COMMENT '版本号',
    creator_id           BIGINT       NULL     DEFAULT NULL COMMENT '创建人ID',
    creator_name         VARCHAR(50)  NULL     DEFAULT NULL COMMENT '创建人名称',
    last_modifier_id     BIGINT       NULL     DEFAULT NULL COMMENT '修改人ID',
    last_modifier_name   VARCHAR(50)  NULL     DEFAULT NULL COMMENT '修改人名称',
    created              DATETIME     NOT NULL DEFAULT NOW() COMMENT '创建时间',
    last_modified        DATETIME     NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后修改时间',
    yn                   TINYINT      NOT NULL DEFAULT 1 COMMENT '有效标记，1：有效，0：无效'
);

# ValueTypes
INSERT INTO `column`(resource, title, data_index, value_type, width, sorter, default_sort_order, hide_in_form, hide_in_table,
                     hide_in_search, hide_in_descriptions, readonly)
VALUES ('value-types', '排序', 'sort', 'text', 60, null, null, false, false, true, false, false),
       ('value-types', '#', 'sortValue', 'indexBorder', 60, null, null, false, false, true, false, false),
       ('value-types', 'ID', 'id', 'text', 60, null, null, false, false, true, false, false),
       ('value-types', '编码', 'code', 'text', null, null, null, false, false, false, false, false),
       ('value-types', '名称', 'name', 'text', null, null, null, false, false, false, false, false),
       ('value-types', '创建时间', 'created', 'dateTime', null, null, null, false, false, true, false, false),
       ('value-types', '最后修改时间', 'lastModified', 'dateTime', null, null, null, false, false, true, false, false);

# DomainEntities
INSERT INTO `column`(resource, view, title, data_index, value_type, width, sorter, default_sort_order, hide_in_form, hide_in_table,
                     hide_in_search, hide_in_descriptions, readonly)
VALUES ('domain-entities', 'create', '资源码', 'resource', 'text', null, null, null, false, false, false, false, false),
       ('domain-entities', 'create', '名称', 'name', 'text', null, null, null, false, false, false, false, false),
       ('domain-entities', 'create', '描述', 'description', 'text', null, null, null, false, false, false, false, false),
       ('domain-entities', 'list', '排序', 'sort', 'text', 60, null, null, true, false, true, true, false),
       ('domain-entities', 'list', '#', 'sortValue', 'indexBorder', 60, null, null, true, false, true, true, false),
       ('domain-entities', 'list', 'ID', 'id', 'text', 60, null, null, false, false, true, false, true),
       ('domain-entities', 'list', '资源码', 'resource', 'select', null, null, null, false, false, false, false, false),
       ('domain-entities', 'list', '名称', 'name', 'text', null, null, null, false, false, false, false, false),
       ('domain-entities', 'list', '描述', 'description', 'text', null, null, null, false, false, false, false, false),
       ('domain-entities', 'list', '创建时间', 'created', 'dateTime', null, null, null, false, false, true, false, true),
       ('domain-entities', 'list', '最后修改时间', 'lastModified', 'dateTime', null, null, null, false, false, true, false, true);

set @view_value_enums = '[
    {
        "text": "列表",
        "code": "list"
    },
    {
        "text": "新建",
        "code": "create"
    },
    {
        "text": "编辑",
        "code": "edit"
    },
    {
        "text": "查看",
        "code": "view"
    }
]';

# Columns
INSERT INTO `column`(resource, view, title, data_index, value_type, width, sorter, default_sort_order, hide_in_form, hide_in_table,
                     hide_in_search, hide_in_descriptions, readonly, value_enum)
VALUES ('columns', 'create', '排序', 'sort', 'text', 60, null, null, true, true, true, true, true, null),
       ('columns', 'create', '#', 'sortValue', 'indexBorder', 60, true, 'ascend', true, false, true, true, false, null),
       ('columns', 'create', '标题', 'title', 'text', null, null, null, false, false, false, false, false, null),
       ('columns', 'create', 'valueType', 'valueType', 'text', null, null, null, false, false, false, false, false, null),
       ('columns', 'create', '视图', 'view', 'select', null, null, null, false, false, false, false, false, @view_value_enums),
       ('columns', 'create', '描述', 'description', 'text', null, null, null, false, false, false, false, false, null),
       ('columns', 'create', '创建时间', 'created', 'dateTime', null, null, null, false, false, true, false, true, null),
       ('columns', 'create', '最后修改时间', 'lastModified', 'dateTime', null, null, null, false, false, true, false, true, null);

set @type_value_enum = '[
    {
        "code": "button",
        "text": "按钮"
}
]';

INSERT INTO `column`(resource, title, data_index, value_type, width, sorter, default_sort_order, hide_in_form, hide_in_table,
                     hide_in_search, hide_in_descriptions, readonly, tip_title, tip_icon, value_enum)
VALUES ('actions', '排序', 'sort', 'text', 60, null, null, false, false, true, false, false, null, null, null),
       ('actions', '#', 'sortValue', 'indexBorder', 60, true, 'ascend', false, false, true, false, false, null, null, null),
       ('actions', '资源', 'resource', 'text', null, null, null, false, false, false, false, false, null, null, null),
       ('actions', '编码', 'code', 'text', null, null, null, false, false, false, false, false, null, null, null),
       ('actions', '名称', 'name', 'text', null, null, null, false, false, false, false, false, null, null, null),
       ('actions', '类型', 'type', 'select', null, null, null, false, false, false, false, false, null, null, @type_value_enum),
       ('actions', 'Tips', 'tips', 'text', null, null, null, false, false, false, false, false, null, null, null),
       ('actions', '表达式', 'eval', 'code', null, null, null, false, false, false, false, false, null,
        '可操作表达式，您可以使用`entity.属性名`来访问记录属性', null),
       ('actions', '描述', 'description', 'text', null, null, null, false, false, false, false, false, null, null, null),
       ('actions', '创建时间', 'created', 'dateTime', null, null, null, false, false, true, false, false, null, null, null),
       ('actions', '最后修改时间', 'lastModified', 'dateTime', null, null, null, false, false, true, false, false, null, null, null);


INSERT INTO `column` (resource, title, data_index, value_type, width, sorter, default_sort_order, hide_in_form, hide_in_table,
                      hide_in_search, hide_in_descriptions, readonly)
VALUES ('menus', '排序', 'sort', 'text', 60, null, null, false, false, false, false, false),
       ('menus', '#', 'sortValue', 'indexBorder', null, true, 'ascend', false, false, false, false, false),
       ('menus', 'ID', 'id', 'number', null, null, null, false, false, false, false, false),
       ('menus', '路径', 'path', 'text', null, null, null, false, false, false, false, false),
       ('menus', '图标', 'icon', 'icon', 100, null, null, false, false, false, false, false),
       ('menus', '名称', 'name', 'text', null, null, null, false, false, false, false, false),
       ('menus', '创建时间', 'created', 'dateTime', null, null, null, false, false, false, false, false),
       ('menus', '最后修改时间', 'lastModified', 'dateTime', null, null, null, false, false, false, false, false),

       ('authorities', '排序', 'sort', 'text', 60, null, null, true, false, false, false, false),
       ('authorities', '#', 'index', 'indexBorder', null, true, null, true, false, false, false, false),
       ('authorities', '编码', 'code', 'text', null, null, null, false, false, false, false, false),
       ('authorities', '名称', 'name', 'text', null, null, null, false, false, false, false, false),
       ('authorities', '密码', 'password', 'password', null, null, null, false, false, false, false, false),
       ('authorities', '金额', 'money', 'money', null, null, null, false, false, false, false, false),
       ('authorities', '文本域', 'textarea', 'textarea', null, null, null, false, false, false, false, false),
       ('authorities', '日期', 'date', 'date', null, null, null, false, false, false, false, false),
       ('authorities', '日期时间', 'dateTime', 'dateTime', null, null, null, false, false, false, false, false),
       ('authorities', '周', 'dateWeek', 'dateWeek', null, null, null, false, false, false, false, false),
       ('authorities', '月', 'dateMonth', 'dateMonth', null, null, null, false, false, false, false, false),
       ('authorities', '季度输入', 'dateQuarter', 'dateQuarter', null, null, null, false, false, false, false, false),
       ('authorities', '年份输入', 'dateYear', 'dateYear', null, null, null, false, false, false, false, false),
       ('authorities', '日期区间', 'dateRange', 'dateRange', null, null, null, false, false, false, false, false),
       ('authorities', '日期时间区间', 'dateTimeRange', 'dateTimeRange', null, null, null, false, false, false, false, false),
       ('authorities', '时间', 'time', 'time', null, null, null, false, false, false, false, false),
       ('authorities', '时间区间', 'timeRange', 'timeRange', null, null, null, false, false, false, false, false),
       ('authorities', '下拉框', 'select', 'select', null, null, null, false, false, false, false, false),
       ('authorities', '树形下拉框', 'treeSelect', 'treeSelect', null, null, null, false, false, false, false, false),
       ('authorities', '多选框', 'checkbox', 'checkbox', null, null, null, false, false, false, false, false),
       ('authorities', '星级组件', 'rate', 'rate', null, null, null, false, false, false, false, false),
       ('authorities', '单选框', 'radio', 'radio', null, null, null, false, false, false, false, false),
       ('authorities', '按钮单选框', 'radioButton', 'radioButton', null, null, null, false, false, false, false, false),
       ('authorities', '进度条', 'progress', 'progress', null, null, null, false, false, false, false, false),
       ('authorities', '百分比组件', 'percent', 'percent', null, null, null, false, false, false, false, false),
       ('authorities', '数字输入框', 'digit', 'digit', null, null, null, false, false, false, false, false),
       ('authorities', '秒格式化', 'second', 'second', null, null, null, false, false, false, false, false),
       ('authorities', '头像', 'avatar', 'avatar', null, null, null, false, false, false, false, false),
       ('authorities', '代码框', 'code', 'code', null, null, null, false, false, false, false, false),
       ('authorities', '开关', 'switch', 'switch', null, null, null, false, false, false, false, false),
       ('authorities', '相对于当前时间', 'fromNow', 'fromNow', null, null, null, false, false, false, false, false),
       ('authorities', '图片', 'image', 'image', null, null, null, false, false, false, false, false),
       ('authorities', '代码框，但是带了 json 格式化', 'jsonCode', 'jsonCode', null, null, null, false, false, false, false, false),
       ('authorities', '颜色选择器', 'color', 'color', null, null, null, false, false, false, false, false),
       ('authorities', '级联选择器', 'cascader', 'cascader', null, null, null, false, false, false, false, false),
       ('authorities', '分段器', 'segmented', 'segmented', null, null, null, false, false, false, false, false),
       ('authorities', '分组', 'group', 'group', null, null, null, false, false, false, false, false),
       ('authorities', '表单列表', 'formList', 'formList', null, null, null, false, false, false, false, false),
       ('authorities', '表单集合', 'formSet', 'formSet', null, null, null, false, false, false, false, false),
       ('authorities', '分割线', 'divider', 'divider', null, null, null, false, false, false, false, false),
       ('authorities', '依赖项', 'dependency', 'dependency', null, null, null, false, false, false, false, false),


       ('authorities', '创建时间', 'created', 'dateTime', null, null, null, true, false, false, false, true),
       ('authorities', '最后修改时间', 'lastModified', 'dateTime', null, null, null, true, false, false, false, true),
       ('authorities', '操作', 'option', 'option', null, null, null, true, false, false, true, false),

       ('roles', 'ID', 'id', 'text', null, true, null, false, false, false, false, false),
       ('roles', '编码', 'code', 'text', null, null, null, false, false, false, false, false),
       ('roles', '名称', 'name', 'text', null, null, null, false, false, false, false, false),
       ('roles', '创建时间', 'created', 'dateTime', null, null, null, false, false, false, false, false),
       ('roles', '最后修改时间', 'lastModified', 'dateTime', null, null, null, false, false, false, false, false)
;






