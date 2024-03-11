package org.ifinalframework.console.sso.sdk;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.validation.SimpleErrors;

import org.ifinalframework.core.result.Result;
import org.ifinalframework.security.sso.authentication.AuthenticationEncoder;
import org.ifinalframework.security.web.authentication.www.RemoteAuthenticationService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FeignRemoteAuthenticationService
 *
 * @author iimik
 * @since 1.5.6
 **/
@Component
public class FeignRemoteAuthenticationService implements RemoteAuthenticationService {

    @Resource
    private FeignRemoteAuthenticationClient feignRemoteAuthenticationClient;
    @Resource
    private JsonAuthenticationDecoder jsonAuthenticationDecoder;

    @Override
    public Authentication load(HttpServletRequest request) {
        final Result<String> result = feignRemoteAuthenticationClient.authentication();
        final org.ifinalframework.security.sso.authentication.Authentication authentication = jsonAuthenticationDecoder.decode(result.getData());
        final List<String> authorities = authentication.getAuthorities();
        return new UsernamePasswordAuthenticationToken(authentication.getUser(),null,         authorities.stream().map(it -> new SimpleGrantedAuthority((String) it)).collect(Collectors.toList()));
    }
}
