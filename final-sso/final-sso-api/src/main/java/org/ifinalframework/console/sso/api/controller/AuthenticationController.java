/*
 * Copyright 2020-2024 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ifinalframework.console.sso.api.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.console.sso.domain.security.SecurityUser;
import org.ifinalframework.console.sso.model.Authentication;
import org.ifinalframework.console.sso.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AuthenticationController
 *
 * @author iimik
 * @since 1.5.6
 **/
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {


    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public Authentication authentication(@RequestHeader(value = "X-SERVICE", required = false) String service, SecurityUser user) {
        final List<String> authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        final Authentication authentication = new Authentication();
        final User targetUser = new User();
        targetUser.setId(user.getId());
        targetUser.setName(targetUser.getName());
        authentication.setUser(targetUser);
        authentication.setAuthorities(authorities);
        return authentication;
    }
}
