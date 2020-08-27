package com.apigateway.spring.boot.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class PreFilter extends ZuulFilter {
    private static Logger log =  LoggerFactory.getLogger(PreFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info("Request method = {}, url = {}", request.getMethod(), request.getRequestURL().toString());

//        if (!request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
//        }
        return null;
    }
}
