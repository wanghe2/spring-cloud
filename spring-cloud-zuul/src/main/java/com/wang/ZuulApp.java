package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.wang.filter.TokenFlilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApp 
{
    public static void main( String[] args )
    {
       SpringApplication.run(ZuulApp.class, args);
    }
    
    @Bean
    public TokenFlilter tokenFlilter() {
    	return new TokenFlilter();
    }
}
