package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * ValueType
 *
 * <a href="https://procomponents.ant.design/components/schema#valuetype-%E5%88%97%E8%A1%A8">ValueType列表</a>
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
@DomainResource("value-types")
public class ValueType extends AbsRecord {
    @NotBlank
    private String code;
    @NotBlank
    private String name;
}
