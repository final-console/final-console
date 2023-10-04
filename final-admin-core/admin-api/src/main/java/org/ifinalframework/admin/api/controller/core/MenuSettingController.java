package org.ifinalframework.admin.api.controller.core;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.resource.service.MenuService;
import org.ifinalframework.admin.entity.resource.Menu;
import org.ifinalframework.admin.model.antd.MenuDataItem;
import org.ifinalframework.admin.repository.resource.query.QMenu;
import org.ifinalframework.data.query.Query;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 菜单设置
 *
 * @author mik
 * @since 1.5.4
 **/
@RestController
@RequestMapping("/api/menu")
public class MenuSettingController {

    private static final MenuDataItem ROOT = new MenuDataItem();

    @Resource
    private MenuService menuService;

    static {
        ROOT.setKey("-1");
        ROOT.setName("根菜单");
        ROOT.setPath("/");
        ROOT.setIcon("root");
    }

    @GetMapping("/menus")
    public List<MenuDataItem> menus() {
        return Stream.concat(Stream.of(ROOT), menus(-1L).stream()).collect(Collectors.toList());
    }

    private List<MenuDataItem> menus(Long parentId) {

        final List<Menu> securityMenus = menuService.select(new Query().where(QMenu.parentId.eq(parentId)).asc(QMenu.sortValue));
        return securityMenus.stream().map(it -> {

            final MenuDataItem menuDataItem = new MenuDataItem();
            menuDataItem.setKey(it.getId().toString());
            menuDataItem.setName(it.getName());
            menuDataItem.setPath(it.getPath());
            menuDataItem.setIcon(it.getIcon());
            final List<MenuDataItem> menus = menus(it.getId());

            if (!CollectionUtils.isEmpty(menus)) {
                final MenuDataItem root = new MenuDataItem();
                root.setKey("-" + it.getId().toString());
                root.setPath(it.getPath() + "/root");
                root.setName(it.getName() + "-根菜单");
                root.setIcon("root");
                final List<MenuDataItem> routes = Stream.concat(Stream.of(root), menus.stream()).collect(Collectors.toList());
                menuDataItem.setRoutes(routes);
            }
            return menuDataItem;
        }).collect(Collectors.toList());
    }

}
