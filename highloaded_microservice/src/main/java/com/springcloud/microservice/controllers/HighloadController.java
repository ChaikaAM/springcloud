package com.springcloud.microservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class HighloadController {

    private final ExecutorService es = Executors.newSingleThreadExecutor();

    /**
     * simply to imitate situation of server failing
     */
    @RequestMapping("kill")
    public String kill() {
        delayedSystemExit();
        return "Killing server. Try to refresh page to make sure if server has stopped";
    }

    private void delayedSystemExit() {
        es.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
