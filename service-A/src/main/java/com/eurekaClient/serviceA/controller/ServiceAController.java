package com.eurekaClient.serviceA.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ServiceAController {

    @GetMapping("/api") //get방식으로 보낼 때
    public String getRequest() {
        return "Hello Service A";
    }

    @GetMapping(value = "/api/{idx}")
    @HystrixCommand(fallbackMethod = "doFallBack") //circuit breaker 역할을 수행할 메소드 에러 발생 시 doFallBack()메소드로 이동
    public String getRequest(@PathVariable("idx") String idx) {
        if (idx.equalsIgnoreCase("error")) //대소문자 관계없이 비교
            throw new RuntimeException();
        return "Hello Service A";
    }

    @PostMapping("/api") //post방식으로 전송
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
