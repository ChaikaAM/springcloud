package com.springcloud.loadbalancing.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("highloaded-microservice")
public interface HighloadedMicroserviceFeignClient {

    @RequestMapping("/about")
    String about();
}
