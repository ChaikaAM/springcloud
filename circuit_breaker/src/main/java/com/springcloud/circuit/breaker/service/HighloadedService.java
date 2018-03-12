package com.springcloud.circuit.breaker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HighloadedService {

    private final int range = 5;

    private int successAmount = range;
    private int counter = 0;

    @HystrixCommand(fallbackMethod = "preventCascadingFailures")
    public String tryToDoHardTask() throws InterruptedException {
        if (counter++ < successAmount) {
            return "I`ve done hard job";
        } else {
            counter = 0;
            if (successAmount > -range * 3) {
                successAmount--;
            } else successAmount = range;
            TimeUnit.SECONDS.sleep(2);
            throw new RuntimeException("Sorry I`ve failed everything");
        }
    }

    @HystrixCommand(fallbackMethod = "preventCascadingFailures")
    public String tryToDoLongTask() throws InterruptedException {
        TimeUnit.SECONDS.sleep(12);
        return "I`ve done long task";
    }

    public String preventCascadingFailures() {
        return "Hystrix fallback method has been invoked";
    }
}
