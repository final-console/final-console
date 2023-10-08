package org.ifinalframework.admin.domain.menu;

import org.ifinalframework.admin.model.antd.MenuDataItem;

import java.util.List;

/**
 * MenuProvider
 *
 * @author mik
 * @since 1.5.5
 **/
public interface MenuProvider {
    List<MenuDataItem> provide();
}
