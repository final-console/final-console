package org.ifinalframework.console.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "org.ifinalframework")
public class FinalAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalAdminApplication.class, args);
    }

}
