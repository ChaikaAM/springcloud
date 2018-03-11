package com.springcloud.loadbalancing.feign.controllers;

import com.springcloud.loadbalancing.feign.client.HighloadedMicroserviceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignBalancingController {

    @Autowired
    HighloadedMicroserviceFeignClient highloadedMicroserviceFeignClient;

    @RequestMapping("/delegate")
    public String delegate() {
        return "Task delegated to: " + System.lineSeparator()
                + highloadedMicroserviceFeignClient.about();
    }
}
