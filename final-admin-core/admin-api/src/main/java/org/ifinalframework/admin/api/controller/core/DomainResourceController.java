package org.ifinalframework.admin.api.controller.core;


import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.admin.domain.resource.service.ActionService;
import org.ifinalframework.admin.domain.resource.service.ColumnService;
import org.ifinalframework.admin.entity.resource.Action;
import org.ifinalframework.admin.entity.resource.Column;
import org.ifinalframework.admin.model.antd.DomainResource;
import org.ifinalframework.admin.model.antd.ProColumns;
import org.ifinalframework.admin.model.antd.ToolTip;
import org.ifinalframework.admin.repository.resource.query.QAction;
import org.ifinalframework.admin.repository.resource.query.QColumn;
import org.ifinalframework.data.query.Query;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * DomainResourceController
 *
 * @author mik
 * @since 1.5.5
 **/
@RestController
@RequestMapping("/api/domain-resource/{resource}")
public class DomainResourceController {

    @Resource
    private ColumnService columnService;
    @Resource
    private ActionService actionService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public DomainResource domainResource(@PathVariable String resource) {

        final List<Column> columns = columnService.select(new Query().where(QColumn.resource.eq(resource)).asc(QColumn.sortValue));

        final Map<String, List<ProColumns>> actionColumns = columns.stream()
                .map(it -> {
                    final ProColumns proColumns = new ProColumns();
                    BeanUtils.copyProperties(it,proColumns);
                    proColumns.setTitle(it.getTitle());
                    proColumns.setDataIndex(it.getDataIndex().split("\\."));
                    proColumns.setValueType(it.getValueType());
                    proColumns.setWidth(it.getWidth());
                    proColumns.setSorter(it.getSorter());
                    proColumns.setDefaultSortOrder(it.getDefaultSortOrder());
                    if (StringUtils.hasText(it.getTipTitle())) {
                        proColumns.setTooltip(new ToolTip(it.getTipTitle(), it.getTipIcon()));
                    }

                    Optional.ofNullable(it.getValueEnum())
                            .ifPresent(valueEnum -> proColumns.setValueEnum(
                                    valueEnum.stream()
                                            .collect(Collectors.toMap(value -> value.get("code"), Function.identity()))
                            ));

                    return proColumns;
                })
                .collect(Collectors.groupingBy(ProColumns::getView));
        final DomainResource domainResource = new DomainResource();
        domainResource.setColumns(actionColumns);

        final List<Action> actions = actionService.select(new Query().where(QAction.resource.eq(resource)).asc(QAction.sortValue));

        domainResource.setActions(actions.stream().map(it -> {
            final org.ifinalframework.admin.model.antd.Action action = new org.ifinalframework.admin.model.antd.Action();
            action.setKey(it.getCode());
            action.setName(it.getName());
            action.setType(it.getType());
            action.setTips(it.getTips());
            action.setEval(it.getEval());
            return action;
        }).collect(Collectors.toList()));


        return domainResource;

    }


}
