package org.ifinalframework.console.sso.api.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProfileController
 *
 * @author mik
 * @since 1.5.6
 **/
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public Object profile() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
