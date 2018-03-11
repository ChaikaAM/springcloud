package com.springcloud.loadbalancing.feign.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${greeting}")
    public String greeting;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/about")
    public String getAbout() {
        return String.join(
                ", ",
                "Application name : " + boiledString(applicationName),
                "port : " + boiledString(String.valueOf(port)),
                "Greeting : " + boiledString(greeting));
    }

    private String boiledString(String text) {
        return "<b>\"" + text + "\"</b>";
    }
}
