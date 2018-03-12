package com.springcloud.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class RoutingApp {

    public static void main(String[] args) {
        SpringApplication.run(RoutingApp.class, args);
    }
}
