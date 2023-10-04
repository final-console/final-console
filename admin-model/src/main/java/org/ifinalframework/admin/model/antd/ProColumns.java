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
    /**
     * <a href="https://procomponents.ant.design/components/schema#valuetype-%E5%88%97%E8%A1%A8">valueType</a>
     */
    private String valueType;
    private Integer width;
}