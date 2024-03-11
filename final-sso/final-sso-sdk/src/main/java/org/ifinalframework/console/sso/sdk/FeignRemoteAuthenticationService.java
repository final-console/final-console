package org.ifinalframework.console.sso.sdk;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import org.ifinalframework.core.result.Result;
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

    @Override
    public Authentication load(HttpServletRequest request) {
        final Result<org.ifinalframework.console.sso.model.Authentication> result = feignRemoteAuthenticationClient.authentication();
        final org.ifinalframework.console.sso.model.Authentication authentication = result.getData();
        final List<SimpleGrantedAuthority> authorities = authentication.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(authentication.getUser(), null, authorities);
    }
}
