package org.ifinalframework.console.sso.sdk;


import org.springframework.stereotype.Component;

import org.ifinalframework.json.Json;
import org.ifinalframework.security.sso.authentication.Authentication;
import org.ifinalframework.security.sso.authentication.AuthenticationDecoder;

/**
 * JsonAuthenticationDecoder
 *
 * @author mik
 * @since 1.5.6
 **/
@Component
public class JsonAuthenticationDecoder implements AuthenticationDecoder {
    @Override
    public Authentication decode(String authentication) {
        return Json.toObject(authentication,org.ifinalframework.console.sso.model.Authentication.class);
    }
}
