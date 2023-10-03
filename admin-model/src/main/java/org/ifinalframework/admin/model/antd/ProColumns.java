package org.ifinalframework.admin.model.antd;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * ProColumns
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
public class ProColumns implements Serializable {
    private String title;
    private String[] dataIndex;
    private String valueType;
    private Integer width;
}