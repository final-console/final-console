package org.ifinalframework.console.admin.entity;

import org.ifinalframework.core.INode;
import org.ifinalframework.core.ISort;
import org.ifinalframework.core.lang.Transient;
import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Menu
 *
 * @author mik
 * @since 0.0.1
 **/
@Setter
@Getter
@DomainResource("menus")
public class Menu extends AbsRecord implements ISort, INode<Long, Menu> {
    private String code;
    private String name;
    private String path;
    private String icon;

    /**
     * 是否隐藏菜单，
     */
    private Boolean hideMenu;

    private Long parentId;
    @Transient
    private List<Menu> children;
    private Integer sortValue;
}
