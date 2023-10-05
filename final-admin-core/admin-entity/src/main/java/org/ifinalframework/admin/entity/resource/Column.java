package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.core.ISort;
import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;
import org.ifinalframework.data.annotation.Table;

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
    private String resource;
    private String title;
    private String dataIndex;
    private String valueType;
    private Integer width;
    private Boolean sorter;
    private String defaultSortOrder;

    /**
     * 只读，用于修改时，不可编辑
     */
    private Boolean readonly;

    private Boolean hideInForm;
    private Boolean hideInTable;
    private Boolean hideInSearch;
    private Boolean hideInDescriptions;

    private Integer sortValue;
}
