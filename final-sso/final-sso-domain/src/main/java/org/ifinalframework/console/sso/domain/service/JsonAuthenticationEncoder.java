package org.ifinalframework.console.sso.domain.service;


import org.springframework.stereotype.Component;

import org.ifinalframework.console.sso.model.Authentication;
import org.ifinalframework.json.Json;
import org.ifinalframework.security.sso.authentication.AuthenticationEncoder;

/**
 * JsonAuthenticationEncoder
 *
 * @author mik
 * @since 1.5.6
 **/
@Component
public class JsonAuthenticationEncoder implements AuthenticationEncoder<Authentication> {

    @Override
    public String encode(Authentication authentication) {
        return Json.toJson(authentication);
    }

}
