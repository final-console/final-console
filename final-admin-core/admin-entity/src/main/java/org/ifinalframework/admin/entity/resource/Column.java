package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.core.INode;
import org.ifinalframework.core.ISort;
import org.ifinalframework.core.lang.Default;
import org.ifinalframework.core.lang.Transient;
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
public class Column extends AbsRecord implements ISort, INode<Long, Column> {
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
    @Default
    private Integer width;
    @Default
    private Boolean sorter;
    @Default
    private String defaultSortOrder;

    /**
     * 只读，用于修改时，不可编辑
     */
    @Default
    private Boolean readonly;

    @Default
    private Boolean filter;

    @Default
    private Boolean hideInForm;
    @Default
    private Boolean hideInTable;
    @Default
    private Boolean hideInSearch;
    @Default
    private Boolean hideInDescriptions;

    @Default
    private Integer sortValue;
    private Long parentId;
    @Transient
    private List<Column> children;
    @Json
    private List<Map<String, String>> valueEnum;

}
