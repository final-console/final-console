package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import java.util.List;

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
@DomainResource("resource-columns")
public class ResourceColumn extends AbsRecord {
    private String resource;
    private String title;
    private String dataIndex;
    private String valueType;
    private Integer width;
    private Boolean sorter;
    private String defaultSortOrder;
}
