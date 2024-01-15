package org.ifinalframework.admin.model.antd;

import java.io.Serializable;
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

    private String view;
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
     * 传递给 Form.Item 的配置,可以配置 rules，但是默认的查询表单 rules 是不生效的。需要配置 ignoreRules
     */
    private Props formItemProps;

    @Setter
    @Getter
    public static class Props {
        private List<Rule> rules;
    }

    @Setter
    @Getter
    public static abstract class Rule {
        private String message;
    }

    @Setter
    @Getter
    public static class RequiredRule extends Rule {
        private Boolean required = true;
    }

}