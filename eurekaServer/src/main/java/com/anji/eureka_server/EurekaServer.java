package com.anji.eureka_server;


import com.netflix.discovery.shared.Application;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).web(WebApplicationType.REACTIVE).run(args);
    }
}
