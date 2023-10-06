package org.ifinalframework.admin.model.antd;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * ProColumns
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
public class ProColumns implements Serializable {
    private String title;
    private String[] dataIndex;
    private ToolTip tooltip;
    /**
     * <a href="https://procomponents.ant.design/components/schema#valuetype-%E5%88%97%E8%A1%A8">valueType</a>
     */
    private String valueType;
    private Integer width;
    private Boolean sorter;
    private String defaultSortOrder;

    private Boolean readonly = true;
    /**
     * 表头的筛选菜单项，当值为 true 时，自动使用 valueEnum 生成
     */
    private Boolean filters = true;
    /**
     * 筛选表单，为 true 时使用 ProTable 自带的，为 false 时关闭本地筛选
     */
    private Boolean onFilter = true;
//    private Boolean ellipsis = true;
    private Boolean hideInForm;
    private Boolean hideInTable;
    private Boolean hideInSearch;
    private Boolean hideInDescriptions;
    private List<Action> actions;
    private Object valueEnum;

    /**
     * Action
     *
     * @author mik
     * @since 1.5.5
     **/
    @Getter
    @Setter
    public static class Action implements Serializable {
        private String key;
        private String name;
        private String type;
        private String tips;
        private String eval;
    }
}