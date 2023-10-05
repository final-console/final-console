package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


/**
 * DomainEntity
 *
 * @author mik
 * @since 1.5.5
 **/
@Getter
@Setter
@DomainResource("domain-entities")
public class DomainEntity extends AbsRecord {
    @NotBlank
    private String resource;
    @NotBlank
    private String name;
    private String description;
}
