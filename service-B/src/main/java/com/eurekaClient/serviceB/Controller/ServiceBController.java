package com.eurekaClient.serviceB.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServiceBController {

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    ResponseEntity<Map<String, String>> sample() {
//        ResponseEntity<Map<String, String>> response = null;
//
//        Map<String, String> resMap = new HashMap<String, String>();
//        resMap.put("type", "First eureka client!");
//        resMap.put("message", "Spring Cloud is awesome!");
//
//        response = new ResponseEntity<Map<String, String>>(resMap, HttpStatus.OK);
//
//        return response;
//    }
    @GetMapping("/api")
    public String serviceB(){
        return "Hello Service B";
    }
    @GetMapping(value = "/api/{idx}")
    public String serviceB(@PathVariable("idx") String idx){
        return "Hello ServiceB";

    }
}
