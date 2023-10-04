package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import lombok.Getter;
import lombok.Setter;

/**
 * Authority
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
@DomainResource("authorities")
public class Authority extends AbsRecord {
    private String code;
    private String name;
}
