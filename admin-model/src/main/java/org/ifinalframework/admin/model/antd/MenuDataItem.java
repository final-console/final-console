package org.ifinalframework.admin.model.antd;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * MenuDateItem
 *
 * @author mik
 * @since 1.5.4
 **/
@Setter
@Getter
public class MenuDataItem implements Serializable {
    private String key;
    private String path;
    private String name;
    private String icon;
    private List<MenuDataItem> routes;
    private Boolean menuRender;
}
