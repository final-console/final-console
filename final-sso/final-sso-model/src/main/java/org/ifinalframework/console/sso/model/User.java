package org.ifinalframework.console.sso.model;

import org.ifinalframework.core.IUser;
import org.ifinalframework.core.lang.Transient;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


/**
 * User
 *
 * @author mik
 * @since 1.5.6
 **/
@Getter
@Setter
@Transient
public class User implements IUser<Long>, Serializable {
    private Long id;
    private String name;
}
