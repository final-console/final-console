package org.ifinalframework.admin.entity.resource;

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
@DomainResource("menus")
public class Menu extends AbsRecord implements ISort {
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
