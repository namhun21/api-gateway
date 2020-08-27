package com.eurekaClient.serviceB.Controller;

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
    public String getRequest(@PathVariable("idx") String idx){
        return "Hello ServiceB";
    }
    @PostMapping("/api")
    public String postRequest(@RequestBody String message){
        return message;
    }
}
