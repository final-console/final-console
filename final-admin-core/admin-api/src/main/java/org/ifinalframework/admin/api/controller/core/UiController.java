package org.ifinalframework.admin.api.controller.core;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.resource.service.ResourceColumnService;
import org.ifinalframework.admin.entity.resource.ResourceColumn;
import org.ifinalframework.admin.model.antd.ProColumns;
import org.ifinalframework.admin.repository.resource.query.QResourceColumn;
import org.ifinalframework.data.query.Query;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UiController
 *
 * @author mik
 * @since 1.5.5
 **/
@RestController
@RequestMapping("/api/ui")
public class UiController {

    @Resource
    private ResourceColumnService resourceColumnService;

    @GetMapping("/{resource}/columns")
    @PreAuthorize("isAuthenticated()")
    public List<ProColumns> columns(@PathVariable String resource) {
        final List<ResourceColumn> resourceColumns = resourceColumnService.select(new Query().where(QResourceColumn.resource.eq(resource)));

        return resourceColumns.stream()
                .map(it -> {
                    final ProColumns columns = new ProColumns();
                    columns.setTitle(it.getTitle());
                    columns.setDataIndex(it.getDataIndex().split("\\."));
                    columns.setValueType(it.getValueType());
                    columns.setWidth(it.getWidth());
                    columns.setSorter(it.getSorter());
                    columns.setDefaultSortOrder(it.getDefaultSortOrder());
                    return columns;
                })
                .collect(Collectors.toList());

    }

}
