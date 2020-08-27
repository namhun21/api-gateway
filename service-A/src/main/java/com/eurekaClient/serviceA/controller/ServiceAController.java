package com.eurekaClient.serviceA.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceAController {

    @GetMapping("/api")
    public String getRequest(){
        return "Hello Service A";
    }
    @GetMapping(value = "/api/{idx}")
    public String getRequest(@PathVariable("idx") String idx){
        return "Hello Service A";
    }
    @PostMapping("/api")
    public String postRequest(@RequestBody String message){
        return message;
    }

}
