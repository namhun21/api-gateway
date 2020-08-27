package com.apigateway.spring.boot.apigateway;

import com.apigateway.spring.boot.apigateway.filter.ErrorFilter;
import com.apigateway.spring.boot.apigateway.filter.PostFilter;
import com.apigateway.spring.boot.apigateway.filter.PreFilter;
import com.apigateway.spring.boot.apigateway.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringBootApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiGatewayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter(){
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter(){
		return new PostFilter();
	}
	@Bean
	public RouteFilter routeFilter(){
		return new RouteFilter();
	}
	@Bean
	public ErrorFilter errorFilter(){
		return new ErrorFilter();
	}
}
