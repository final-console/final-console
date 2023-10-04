package org.ifinalframework.admin.entity.core;

import org.ifinalframework.core.IUser;
import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import lombok.Getter;
import lombok.Setter;

/**
 * User
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
@DomainResource("users")
public class User extends AbsRecord implements IUser<Long> {
    private String name;
    private String username;
    private String password;
    private String avatar;
}
