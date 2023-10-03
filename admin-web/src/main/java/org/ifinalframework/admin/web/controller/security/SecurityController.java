package org.ifinalframework.admin.web.controller.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.security.service.SecurityMenuService;
import org.ifinalframework.admin.entity.security.SecurityMenu;
import org.ifinalframework.admin.model.antd.MenuDataItem;
import org.ifinalframework.admin.repository.security.query.QSecurityMenu;
import org.ifinalframework.data.query.Query;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * SecurityController
 *
 * @author mik
 * @since 1.5.4
 **/
@RestController
@RequestMapping("/api/security")
public class SecurityController {

    private static final MenuDataItem ROOT = new MenuDataItem();

    @Resource
    private SecurityMenuService securityMenuService;

    static {
        ROOT.setKey("/");
        ROOT.setName("根菜单");
        ROOT.setPath("/");
        ROOT.setIcon("smile");
    }

    @GetMapping("/menus")
    public List<MenuDataItem> menus() {

        final List<SecurityMenu> securityMenus = securityMenuService.select(new Query().where(QSecurityMenu.parentId.eq(-1L)).asc(QSecurityMenu.sortValue));

        return Stream.concat(Stream.of(ROOT), securityMenus.stream().map(it -> {
            final MenuDataItem menuDataItem = new MenuDataItem();
            menuDataItem.setKey(it.getId().toString());
            menuDataItem.setName(it.getName());
            menuDataItem.setPath(it.getPath());
            menuDataItem.setIcon(it.getIcon());
            return menuDataItem;
        })).collect(Collectors.toList());

    }

}
