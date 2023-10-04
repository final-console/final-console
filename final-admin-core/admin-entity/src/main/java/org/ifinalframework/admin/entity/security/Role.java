package org.ifinalframework.admin.entity.security;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import lombok.Getter;
import lombok.Setter;

/**
 * Role
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
@DomainResource("roles")
public class Role extends AbsRecord {

    private String code;

    private String name;

    private String description;
}
