package com.eurekaClient.serviceB.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServiceBController {

    @GetMapping("/api")
    public String getRequest(){
        return "Hello Service B";
    }
    @GetMapping(value = "/api/{idx}")
    @HystrixCommand(fallbackMethod = "doFallBack")
    public String getRequest(@PathVariable("idx") String idx){
        if (idx.equalsIgnoreCase("error"))
            throw new RuntimeException();
        return "Hello ServiceB";
    }
    @PostMapping("/api")
    @HystrixCommand(fallbackMethod = "doFallBack")
    public String postRequest(@RequestBody String message){
        if (message.equalsIgnoreCase("error"))
            throw new RuntimeException();
        return message;
    }

    public String doFallBack(@RequestBody String message) {
        return "Fall Back";
    }
}
