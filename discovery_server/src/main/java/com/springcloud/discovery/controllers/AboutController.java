package com.springcloud.discovery.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope   //POST host/refresh
public class AboutController {

    @Value("${spring.application.name}")
    private String applicationName;


    @Value("${greeting: ((((( SORRY. Somehow I dont use configs from configuration server}")
    public String greeting;

    @RequestMapping("/about")
    public String getAbout() {

        return String.join(
                ", ",
                "Application name : " + boiledString(applicationName),
                "Greeting : " + boiledString(greeting));
    }

    private String boiledString(String text) {
        return "<b>\"" + text + "\"</b>";
    }
}
