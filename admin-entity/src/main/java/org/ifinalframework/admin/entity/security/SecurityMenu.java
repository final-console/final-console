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
    private String name;
    private String path;
    private String icon;
    private Long parentId;
    private Integer sortValue;
}
