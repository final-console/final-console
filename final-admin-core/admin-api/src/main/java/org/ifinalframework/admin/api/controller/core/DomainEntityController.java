package org.ifinalframework.admin.api.controller.core;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.resource.service.DomainEntityService;
import org.ifinalframework.admin.model.antd.MenuDataItem;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DomainEntityController
 *
 * @author mik
 * @since 1.5.5
 **/
@RestController
@RequestMapping("/api/domain-entities")
public class DomainEntityController {

    @Resource
    private DomainEntityService domainEntityService;

    @GetMapping("/menus")
    public List<MenuDataItem> menus() {

        return domainEntityService.select().stream()
                .map(it -> {
                    final MenuDataItem menu = new MenuDataItem();
                    menu.setKey(it.getResource());
                    menu.setName(it.getName());
                    menu.setPath(it.getResource());
                    return menu;
                })
                .collect(Collectors.toList());

    }
}
