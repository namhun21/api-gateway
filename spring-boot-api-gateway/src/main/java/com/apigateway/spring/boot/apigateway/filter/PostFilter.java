package com.apigateway.spring.boot.apigateway.filter;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PostFilter extends ZuulFilter {
    private static Logger log =  LoggerFactory.getLogger(PostFilter.class);
    @Override
    public String filterType() {
        return "post";
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
        HttpServletResponse response = context.getResponse();
        //ctx.getResponse().setStatus(500);
        log.info("Response  Status= {}", response.getStatus());

        try (InputStream is = context.getResponseDataStream()) {
            String respData = CharStreams.toString(new InputStreamReader(is, CharEncoding.UTF_8));
            log.info("Response  Data = {}", respData);
            context.setResponseBody(respData);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //context.getResponse().addHeader("Trace-ID", UUID.randomUUID().toString());
        return null;
    }
}
