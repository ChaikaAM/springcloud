package com.springcloud.loadbalancing.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceWithRibbon {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceWithRibbon.class, args);
    }
}
