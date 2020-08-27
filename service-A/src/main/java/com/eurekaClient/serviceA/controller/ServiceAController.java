package com.eurekaClient.serviceA.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ServiceAController {

    @GetMapping("/api")
    public String getRequest() {
        return "Hello Service A";
    }

    @GetMapping(value = "/api/{idx}")
    @HystrixCommand(fallbackMethod = "doFallBack")
    public String getRequest(@PathVariable("idx") String idx) {
        if (idx.equalsIgnoreCase("error"))
            throw new RuntimeException();
        return "Hello Service A";
    }

    @PostMapping("/api")
    @HystrixCommand(fallbackMethod = "doFallBack")
    public String postRequest(@RequestBody String message) {
        if (message.equalsIgnoreCase("error"))
            throw new RuntimeException();

        return message;
    }

    public String doFallBack(@RequestBody String message) {
            return "Fall Back";
        }
}
