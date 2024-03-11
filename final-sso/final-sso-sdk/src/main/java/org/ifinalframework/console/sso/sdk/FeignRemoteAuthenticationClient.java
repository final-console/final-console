package org.ifinalframework.console.sso.sdk;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.ifinalframework.core.result.Result;

/**
 * FeignRemoteAuthenticationClient
 *
 * @author iimik
 * @since 1.5.6
 **/
@FeignClient(name = "feign-remote-authentication-client",url = "${feign.client.url:http://localhost:8080}")
public interface FeignRemoteAuthenticationClient {
    @GetMapping("/api/sso/authentication")
    Result<String> authentication();
}
