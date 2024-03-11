package org.ifinalframework.console.sso.model;

import org.ifinalframework.core.IUser;

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
public class User implements IUser<Long>, Serializable {
    private Long id;
    private String name;
}
