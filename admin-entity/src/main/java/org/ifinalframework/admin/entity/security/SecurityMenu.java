package org.ifinalframework.admin.entity.security;

import org.ifinalframework.core.ISort;
import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import lombok.Getter;
import lombok.Setter;

/**
 * Menu
 *
 * @author mik
 * @since 1.5.4
 **/
@Setter
@Getter
@DomainResource("security-menus")
public class SecurityMenu extends AbsRecord implements ISort {
    private String code;
    private String name;
    private String path;
    private String icon;

    /**
     * 是否渲染菜单，true:渲染，false:不渲染
     */
    private Boolean menuRender;

    private Long parentId;
    private Integer sortValue;
}
