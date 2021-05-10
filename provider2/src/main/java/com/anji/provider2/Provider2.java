package com.anji.provider2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableFeignClients
@RestController
@EnableDiscoveryClient
public class Provider2 {

    @Autowired
    HelloClient helloClient;

    @Autowired
    DiscoveryClient discoveryClient;

    public static void main(String[] args) {

        new SpringApplicationBuilder(Provider2.class).web(WebApplicationType.SERVLET).run(args);

    }

    @Bean
//    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @GetMapping("/")
    public String test(){
        return helloClient.hello();
    }

    @FeignClient("Provider")
    interface HelloClient {
        @RequestMapping(value = "/", method = GET)
        String hello();
    }

}
