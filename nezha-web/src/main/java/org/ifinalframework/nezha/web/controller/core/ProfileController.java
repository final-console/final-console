package org.ifinalframework.nezha.web.controller.core;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.nezha.entity.core.User;

/**
 * ProfileController
 *
 * @author mik
 * @since 1.5.2
 **/
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public User profile(User user){
        return user;
    }

}
