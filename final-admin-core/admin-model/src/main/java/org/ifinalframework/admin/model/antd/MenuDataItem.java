package org.ifinalframework.admin.model.antd;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 * MenuDateItem
 *
 * <a href="https://procomponents.ant.design/components/layout#%E5%92%8C-umi-%E4%B8%80%E8%B5%B7%E4%BD%BF%E7%94%A8">MenuDateItem</a>
 *
 * @author mik
 * @since 1.5.4
 **/
@Setter
@Getter
public class MenuDataItem implements Serializable {
    private String key;
    /**
     * 路径,可以设定为网页链接
     */
    private String path;
    /**
     * 菜单的名字
     */
    private String name;
    /**
     * 菜单的icon,如果使用了iconfont,需要在前面加上{@code icon-}
     */
    private String icon;
    /**
     * 子菜单
     */
    private List<MenuDataItem> children;
    /**
     * 是否在菜单中显示，只能返回false
     */
    private Boolean menuRender;
    /**
     * 在菜单中隐藏自己和子节点
     */
    private Boolean hideInMenu;
    /**
     * 在菜单中隐藏子节点
     */
    private Boolean hideChildrenInMenu;
    /**
     * 在面包屑中隐藏自己
     */
    private Boolean hideInBreadcrumb;
    /**
     * 禁用
     */
    private Boolean disabled;


    public Boolean getMenuRender() {
        return Boolean.FALSE.equals(menuRender) ? false : null;
    }


    public String getIcon() {
        if (Objects.isNull(icon)) {
            return null;
        }
        if (icon.startsWith("icon-")) {
            return icon;
        }
        return "icon-" + icon;
    }
}
