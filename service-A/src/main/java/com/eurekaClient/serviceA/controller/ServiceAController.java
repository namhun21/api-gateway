package com.eurekaClient.serviceA.controller;

import com.eurekaClient.serviceA.model.SearchVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceAController {

    @GetMapping("/api")
    public String serviceA(){
        return "Hello Service A";
    }
    @GetMapping(value = "/api/{idx}")
    public String serviceA(@PathVariable("idx") String idx){
        return "Hello Service A";
    }
    @RequestMapping(method = RequestMethod.POST, path = "/api")
    public SearchVO postRequest(@RequestBody SearchVO searchVO){
        return searchVO;
    }
}
