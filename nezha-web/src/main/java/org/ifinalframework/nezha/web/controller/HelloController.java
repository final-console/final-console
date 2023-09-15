package org.ifinalframework.nezha.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author mik
 * @since 1.5.2
 **/
@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "Hello!, I'm Nezha!";
    }
}
