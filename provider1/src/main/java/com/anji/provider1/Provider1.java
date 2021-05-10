package com.anji.provider1;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController

public class Provider1 {


    public static void main(String[] args) {
        new SpringApplicationBuilder(Provider1.class).web(WebApplicationType.SERVLET).run(args);
    }



    @GetMapping("hello")
    public String hello(){
        return "hello world";
    }
}
