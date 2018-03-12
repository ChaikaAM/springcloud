package com.springcloud.circuit.breaker.controllers;

import com.springcloud.circuit.breaker.service.HighloadedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighloadedController {

    @Autowired
    HighloadedService highloadedService;

    @RequestMapping("/task/hard")
    public String doHardTask() throws InterruptedException {
        return highloadedService.tryToDoHardTask();
    }

    @RequestMapping("/task/long")
    public String doLongTask() throws InterruptedException {
        return highloadedService.tryToDoLongTask();
    }
}
