package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.data.annotation.AbsRecord;

import lombok.Getter;
import lombok.Setter;

/**
 * Resources
 *
 * @author mik
 * @since 1.5.4
 **/
@Setter
@Getter
@org.ifinalframework.data.annotation.DomainResource("resources")
public class DomainResource extends AbsRecord {
    private String code;
    private String name;
}
