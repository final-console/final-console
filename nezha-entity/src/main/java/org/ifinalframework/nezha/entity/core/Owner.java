package org.ifinalframework.nezha.entity.core;

import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import lombok.Getter;
import lombok.Setter;

/**
 * Owner
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
@DomainResource("owners")
public class Owner extends AbsRecord {

    private Long userId;
    private String userName;

    private String avatar;
    private String name;
    private String description;
    private Type type;

    public enum Type {
        USER, ORGAN
    }


}
