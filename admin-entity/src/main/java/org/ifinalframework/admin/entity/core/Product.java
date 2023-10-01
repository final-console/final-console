package org.ifinalframework.admin.entity.core;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import lombok.Getter;
import lombok.Setter;

/**
 * Product
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
@DomainResource("products")
public class Product extends AbsRecord {
    private Long owner;
    private String name;
    private String description;
    private String avatar;
}
