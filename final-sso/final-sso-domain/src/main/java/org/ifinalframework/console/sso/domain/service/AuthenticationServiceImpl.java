package org.ifinalframework.console.sso.domain.service;


import org.springframework.stereotype.Component;

import org.ifinalframework.console.sso.domain.security.SecurityUser;
import org.ifinalframework.console.sso.model.Authentication;
import org.ifinalframework.console.sso.model.User;
import org.ifinalframework.security.sso.authentication.AuthenticationService;

import java.util.Arrays;

/**
 * JsonAuthenticationEncoder
 *
 * @author mik
 * @since 1.5.6
 **/
@Component
public class AuthenticationServiceImpl implements AuthenticationService<SecurityUser> {

    @Override
    public org.ifinalframework.security.sso.authentication.Authentication lode(String service, SecurityUser user) {
        final Authentication authentication = new Authentication();
        final User targetUser = new User();
        targetUser.setId(user.getId());
        targetUser.setName(user.getName());
        authentication.setUser(targetUser);
        authentication.setAuthorities(Arrays.asList("ROLE_ROOT"));
        return authentication;
    }
}
