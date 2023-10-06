package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.core.ISort;
import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;
import org.ifinalframework.data.annotation.Json;
import org.ifinalframework.data.annotation.Table;

import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * ResourceColumn
 *
 * @author mik
 * @since 1.5.4
 **/
@Setter
@Getter
@DomainResource("columns")
@Table("`column`")
public class Column extends AbsRecord implements ISort {
    /**
     * 资源
     */
    @NotBlank
    private String resource;
    /**
     * 视图
     */
    @NotBlank
    private String view;
    private String title;
    /**
     * 提示信息
     */
    private String tipTitle;
    /**
     * 提示图标
     */
    private String tipIcon;
    private String dataIndex;
    private String valueType;
    private Integer width;
    private Boolean sorter;
    private String defaultSortOrder;

    /**
     * 只读，用于修改时，不可编辑
     */
    private Boolean readonly;

    private Boolean filter;

    private Boolean hideInForm;
    private Boolean hideInTable;
    private Boolean hideInSearch;
    private Boolean hideInDescriptions;

    private Integer sortValue;
    @Json
    private List<Map<String,String>> valueEnum;
}
