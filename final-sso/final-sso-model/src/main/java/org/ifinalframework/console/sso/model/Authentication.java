package org.ifinalframework.console.sso.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * Authentication
 *
 * @author mik
 * @since 1.5.6
 **/
@Getter
@Setter
public class Authentication implements org.ifinalframework.security.sso.authentication.Authentication<User> {
    private User user;
    private List<String> authorities;
}
