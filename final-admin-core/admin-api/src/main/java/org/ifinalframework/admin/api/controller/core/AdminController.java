package org.ifinalframework.admin.api.controller.core;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.resource.service.MenuService;
import org.ifinalframework.admin.entity.core.User;
import org.ifinalframework.admin.entity.resource.Menu;
import org.ifinalframework.admin.model.antd.MenuDataItem;
import org.ifinalframework.admin.repository.resource.query.QMenu;
import org.ifinalframework.data.query.Query;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 管理台控制器
 *
 * @author mik
 * @since 1.5.4
 **/
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Resource
    private MenuService menuService;


    @GetMapping("/menus")
    @PreAuthorize("isAuthenticated()")
    public List<MenuDataItem> menus(User user) {
        return menus(-1L, user);
    }

    private List<MenuDataItem> menus(Long parentId, User user) {
        // TODO 找到用户授权菜单
        final List<Menu> securityMenus = menuService.select(new Query().where(QMenu.parentId.eq(parentId)).asc(QMenu.sortValue));
        return securityMenus.stream()
                .map(it -> {
                    final MenuDataItem menuDataItem = new MenuDataItem();
                    BeanUtils.copyProperties(it, menuDataItem);
                    menuDataItem.setKey(it.getId().toString());
                    menuDataItem.setIcon(it.getIcon());
                    menuDataItem.setPath(it.getPath());

                    if (Objects.nonNull(it.getCode())) {
                        // 找到最后一个.后面的内容
                        String[] split = it.getCode().split("\\.");
                        menuDataItem.setName(split[split.length - 1]);
                    } else {
                        menuDataItem.setName(it.getName());
                    }

                    menuDataItem.setRoutes(menus(it.getId(), user));
                    menuDataItem.setMenuRender(it.getMenuRender());
                    return menuDataItem;
                })
                .collect(Collectors.toList());


    }

}
