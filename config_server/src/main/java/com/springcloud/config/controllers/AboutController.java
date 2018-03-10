package com.springcloud.config.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/about")
    public String getAbout() {
        return "Application name : " + boiledString(applicationName);
    }

    private String boiledString(String text) {
        return "<b>\"" + text + "\"</b>";
    }
}
