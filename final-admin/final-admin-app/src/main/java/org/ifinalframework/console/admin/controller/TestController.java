package org.ifinalframework.console.admin.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author mik
 * @since 1.5.6
 **/
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String test() {
        return "test";
    }
}
