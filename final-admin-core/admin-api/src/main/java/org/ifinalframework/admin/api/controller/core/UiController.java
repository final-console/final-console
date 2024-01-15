package org.ifinalframework.admin.api.controller.core;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.resource.service.ActionService;
import org.ifinalframework.admin.domain.resource.service.ColumnService;
import org.ifinalframework.admin.entity.resource.Action;
import org.ifinalframework.admin.entity.resource.Column;
import org.ifinalframework.admin.model.antd.ProColumns;
import org.ifinalframework.admin.model.antd.ToolTip;
import org.ifinalframework.admin.repository.resource.query.QAction;
import org.ifinalframework.admin.repository.resource.query.QColumn;
import org.ifinalframework.data.query.Query;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
    private ColumnService columnService;
    @Resource
    private ActionService actionService;

    @GetMapping("/{resource}/columns")
    @PreAuthorize("isAuthenticated()")
    public List<ProColumns> columns(@PathVariable String resource) {
        final List<Column> resourceColumns = columnService.select(
                new Query()
                        .where(QColumn.resource.eq(resource))
                        .asc(QColumn.sortValue)
        );

        final List<Action> actions = actionService.select(
                new Query()
                        .where(QAction.resource.eq(resource))
                        .asc(QAction.sortValue)
        );


        final List<ProColumns> proColumns = resourceColumns.stream().map(it -> {
            final ProColumns columns = new ProColumns();
            BeanUtils.copyProperties(it, columns);
            columns.setTitle(it.getTitle());
            columns.setDataIndex(it.getDataIndex().split("\\."));
            columns.setValueType(it.getValueType());
            columns.setWidth(it.getWidth());
            columns.setSorter(it.getSorter());
            columns.setDefaultSortOrder(it.getDefaultSortOrder());
            if (StringUtils.hasText(it.getTipTitle())) {
                columns.setTooltip(new ToolTip(it.getTipTitle(), it.getTipIcon()));
            }

            Optional.ofNullable(it.getValueEnum())
                            .ifPresent(valueEnum -> columns.setValueEnum(
                                    valueEnum.stream()
                                            .collect(Collectors.toMap(value -> value.get("code"), Function.identity()))
                            ));
            return columns;
        }).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(actions)) {
            final ProColumns actionColumn = new ProColumns();
            actionColumn.setTitle("操作");
            actionColumn.setValueType("option");
            actionColumn.setActions(actions.stream().map(it -> {
                final org.ifinalframework.admin.model.antd.Action action = new org.ifinalframework.admin.model.antd.Action();
                BeanUtils.copyProperties(it, action);
                action.setKey(it.getCode());
                return action;
            }).collect(Collectors.toList()));
            proColumns.add(actionColumn);
        }

        return proColumns;

    }

}
